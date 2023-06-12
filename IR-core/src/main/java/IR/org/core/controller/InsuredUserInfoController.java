package IR.org.core.controller;


import IR.org.common.utils.R;
import IR.org.core.config.MyThreadLocal;
import IR.org.core.entity.AdminInfo;
import IR.org.core.entity.InsuredUserInfo;
import IR.org.core.service.InsuredUserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author shuangshuang.li
 * @since 2023-04-14
 */
@RestController
@Api(tags = "受保人信息")
@RequestMapping("/insuredUserInfo")
public class InsuredUserInfoController {

    @Autowired
    private InsuredUserInfoService insuredUserInfoService;

    @Resource
    private MyThreadLocal threadLocal;

    @GetMapping("/getInfo")
    @ApiOperation("获取受保人信息by手机号")
    public R getInfoByPhone(@RequestParam("phone") String phone){
        AdminInfo adminInfo = threadLocal.get();
        String[] str = adminInfo.getAuthority().split(",");
        for (String s:str){
            if (s.equals("1"))
                break;
            else
                return R.error(403,"权限不足！");
        }
        InsuredUserInfo info = insuredUserInfoService.getInfoByPhone(phone);
        if (info==null){
            return R.error(400,"查无用户");
        }
        return R.ok(200,"查找成功！").setData(info);
    }
}

