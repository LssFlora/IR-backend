package IR.org.core.service;

import IR.org.core.entity.InsuredUserInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author shuangshuang.li
 * @since 2023-04-14
 */
public interface InsuredUserInfoService extends IService<InsuredUserInfo> {

    InsuredUserInfo getInfoByPhone(String s);
}
