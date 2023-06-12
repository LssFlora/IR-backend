package IR.org.core.config;

import IR.org.core.entity.AdminInfo;
import IR.org.core.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class MyThreadLocal{

    private static final ThreadLocal<AdminInfo> THREAD_LOCAL = new ThreadLocal<>();

    public AdminInfo get(){
        return THREAD_LOCAL.get();
    }

    public void set(AdminInfo adminInfo){
         THREAD_LOCAL.set(adminInfo);
    }

    public void remove(){
        THREAD_LOCAL.remove();
    }

}
