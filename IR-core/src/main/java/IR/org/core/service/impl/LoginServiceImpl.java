package IR.org.core.service.impl;

import IR.org.common.utils.AesUtil;
import IR.org.common.utils.JwtUtil;
import IR.org.common.utils.R;
import IR.org.core.entity.AdminInfo;
import IR.org.core.service.LoginService;
import IR.org.core.vo.AdminLoginVo;
import IR.org.core.vo.LoginUser;
import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.ShearCaptcha;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class LoginServiceImpl implements LoginService {

    private static final String prefixName = "User:Login:";
    private static final String prefixLogin = "Login:Code:";
    @Resource
    private AuthenticationManager authenticationManager;
    @Resource
    private RedisTemplate redisTemplate;

    @Override
    @Transactional
    public R login(AdminLoginVo user) throws Exception {
        String code = (String) redisTemplate.opsForValue().get(prefixLogin+user.getUserName());
        if(!StringUtils.equals(code,user.getCode())) {
            return R.error(4141, "验证码错误或失效，请重新获取！");
        }
        String decrypt = AesUtil.decrypt(user.getPassword());
        log.info(decrypt);
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUserName(),decrypt);
        Authentication authenticate = authenticationManager.
                authenticate(authenticationToken);
        if(Objects.isNull(authenticate)){
            throw new RuntimeException("用户名或密码错误");
        }
        //使用userid生成token
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        AdminInfo adminInfo = loginUser.getAdminInfo();
        String accountNumber = adminInfo.getAccountNumber();
        String jwt = JwtUtil.createJWT(accountNumber,loginUser.getUserId());
        //authenticate存入redis
        redisTemplate.opsForValue().set(prefixName+accountNumber,loginUser.getAdminInfo());
        //把token响应给前端
        HashMap<String,String> map = new HashMap<>();
        map.put("token",jwt);
        if(adminInfo.getAuthority().length()>1)
            map.put("Authority","4");
        else
            map.put("Authority",adminInfo.getAuthority());
        return R.ok( 200,"登陆成功").setData(map);
    }

    @Override
    public R logout() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        String userName = loginUser.getUsername();
        redisTemplate.delete(prefixName+userName);
        return R.ok(200,"退出成功");
    }

    @Override
    public void getCode(String id,HttpServletResponse response) {
        // 随机生成 4 位验证码
        ShearCaptcha captcha = CaptchaUtil.createShearCaptcha(150, 60, 4, 4);
        redisTemplate.opsForValue().set(prefixLogin+id,captcha.getCode(),60, TimeUnit.SECONDS);
        try {
            response.setContentType("image/jpeg");//设置相应类型,告诉浏览器输出的内容为图片
            response.setHeader("Pragma", "No-cache");//设置响应头信息，告诉浏览器不要缓存此内容
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expire", 0);
            // 调用父类的 setGenerator() 方法，设置验证码的类型
            // 输出到页面
            captcha.write(response.getOutputStream());
            // 打印日志
            log.info("生成的验证码:{}", captcha.getCode());
            // 关闭流
            response.getOutputStream().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
