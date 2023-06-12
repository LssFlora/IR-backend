package IR.org.core.Handler;


import IR.org.core.dao.AdminInfoMapper;
import IR.org.core.dao.UserInfoMapper;
import IR.org.core.entity.AdminInfo;
import IR.org.core.entity.UserInfo;
import IR.org.core.vo.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Resource
    private AdminInfoMapper adminInfoMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //按用户名查询
        AdminInfo adminInfo = adminInfoMapper.getByAddminAccount(s);
        if(adminInfo==null){
            throw new UsernameNotFoundException("用户名不存在");
        }
        //返回正确的用户信息
        List<String> permissionKeyList =  new ArrayList<>();
        String[] split = adminInfo.getAuthority().split(",");
        for (String str:split){
            permissionKeyList.add(str);
        }
        return new LoginUser(adminInfo,permissionKeyList);
    }

}
