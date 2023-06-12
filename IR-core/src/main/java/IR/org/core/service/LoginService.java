package IR.org.core.service;

import IR.org.common.utils.R;
import IR.org.core.vo.AdminLoginVo;


import javax.servlet.http.HttpServletResponse;

public interface LoginService {
    public R login(AdminLoginVo user) throws Exception;
    public R logout();

    void getCode(String id,HttpServletResponse response);
}
