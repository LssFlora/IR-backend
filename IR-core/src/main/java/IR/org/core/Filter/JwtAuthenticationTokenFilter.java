package IR.org.core.Filter;

import IR.org.common.utils.JwtUtil;
import IR.org.core.config.MyThreadLocal;
import IR.org.core.entity.AdminInfo;
import IR.org.core.vo.LoginUser;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@Component
@Slf4j
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    private static final String prefixName = "User:Login:";

    private String regex = "(/user/userInfo/addUser)|(/login/in)|(/login/getCode/.*)|(/doc\\.html)|(/swagger-ui\\.html/.*)|(/.*/swagger-ui\\.html)|(/favicon\\.ico)|(/swagger-resources/.*)|(/error)|(/webjars/.*)|(/v2/.*)";

    @Resource
    private RedisTemplate redisTemplate;
    @Resource
    private MyThreadLocal threadLocal;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String requestURI = request.getRequestURI();
        if (!StringUtils.isEmpty(regex)&&requestURI.matches(regex)) {
            //放行
            filterChain.doFilter(request, response);
            return;
        }

        String token = request.getHeader("token");
        if (!StringUtils.hasText(token)) {
            //放行
            filterChain.doFilter(request, response);
            return;
        }

        //解析token
        String username;
        Map<String, Object> map = new HashMap<>();
        try {
            Claims claims = JwtUtil.parseJWT(token);
            username = claims.getSubject();
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code",4111);
            map.put("msg","token非法");
            String json = new ObjectMapper().writeValueAsString(map);
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().println(json);
            return;
        }
        //从redis中获取用户信息
        String redisKey = prefixName + username;
        AdminInfo adminInfo = (AdminInfo) redisTemplate.opsForValue().get(redisKey);
        if(Objects.isNull(adminInfo)){
            map.put("code",4112);
            map.put("msg","用户未登录");
            String json = new ObjectMapper().writeValueAsString(map);
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().println(json);
            return;

        }
        threadLocal.set(adminInfo);
        //存入SecurityContextHolder
        LoginUser loginUser = new LoginUser();
        loginUser.setAdminInfo(adminInfo);
        //TODO 获取权限信息封装到Authentication中
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginUser,null,null);
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        //放行
        filterChain.doFilter(request, response);
        log.info("threadLocal remove filter");
        threadLocal.remove();
    }
}