//package IR.org.core.controller;
//
//
//import IR.org.common.utils.R;
//import IR.org.core.config.MyThreadLocal;
//import IR.org.core.entity.UserInfo;
//import IR.org.core.service.FileService;
//import IR.org.core.vo.AdminLoginVo;
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import org.apache.commons.lang.StringUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//import javax.annotation.Resource;
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Objects;
//
///**
// * <p>
// * 用户表 前端控制器
// * </p>
// *
// * @author haoyun.xiong
// * @since 2023-03-20
// */
//@RestController
//@Api(tags = "用户crud")
//@RequestMapping("/user/userInfo")
//public class UserInfoController {
//
//
//    @Autowired
//    private FileService fileService;
//
//    @Resource
//    private MyThreadLocal threadLocal;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @PostMapping("/addUser")
//    @ApiOperation(value = "增加用户")
//    public R addUser(@RequestBody AdminLoginVo adminLoginVo){
//        UserInfo one = userInfoService.getOne(new QueryWrapper<UserInfo>().eq("user_name", adminLoginVo.getUserName()));
//        if (one!=null){
//            return R.error(4000,"该用户已存在！");
//        }
//        String encode = passwordEncoder.encode(adminLoginVo.getPassword());
//        UserInfo userInfo = new UserInfo();
//        userInfo.setPassword(encode);
//        userInfo.setUserName(adminLoginVo.getUserName());
//        boolean save = userInfoService.save(userInfo);
//        return save?R.ok("注册成功！"):R.error(400,"注册失败！");
//    }
//
//    @PostMapping("/updateInfo")
//    @ApiOperation(value = "添加用户信息")
//    public R updateInfo(@RequestBody UserInfo userInfo){
//        userInfo.setId(threadLocal.get().getId());
//        boolean update = userInfoService.updateById(userInfo);
//        return update?R.ok(200,"更新成功！"):R.error(400,"失败！");
//    }
//
//    @PostMapping("/updatePicture")
//    @ApiOperation(value = "上传用户头像")
//    public R updatePicture(MultipartFile picture) {
//        String pictureUrl;
//        try {
//            pictureUrl = fileService.fileupService(picture.getInputStream(), picture.getOriginalFilename(), "headPicture");
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        return StringUtils.isNotEmpty(pictureUrl) ? R.ok(200,"上传成功！").setData(pictureUrl) : R.error(400,"上传失败！");
//    }
//
//
//    @ApiOperation("我的主页")
//    @GetMapping("/getInformation")
//    public R getInformation(){
//        Long id = threadLocal.get().getId();
//        UserInfo userInfo= userInfoService.getById(id);
//        if (Objects.isNull(userInfo))
//            return R.error(400,"未找到该用户");
//        Map<String,Object> map = new HashMap<>();
//        map.put("user",userInfo);
//        return R.ok(200,"成功！").setData(map);
//    }
//}
//
