package IR.org.core.controller;

import IR.org.common.utils.R;
import IR.org.core.service.LoginService;
import IR.org.core.vo.AdminLoginVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@Slf4j
@Api(tags = "用户登录")
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private LoginService loginService;


    @PostMapping("in")
    public R userLogin(@RequestBody AdminLoginVo info) throws Exception {
        return loginService.login(info);
    }

    @GetMapping("out")
    public R userOut(){
        return loginService.logout();
    }

    @ApiOperation("获取验证码")
    @GetMapping("/getCode/{id}")
    public void getCode(@PathVariable("id")String id,HttpServletResponse response) {
      loginService.getCode(id,response);
    }

}
