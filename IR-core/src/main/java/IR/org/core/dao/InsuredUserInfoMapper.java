package IR.org.core.dao;

import IR.org.core.entity.InsuredUserInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author shuangshuang.li
 * @since 2023-04-14
 */
public interface InsuredUserInfoMapper extends BaseMapper<InsuredUserInfo> {

  InsuredUserInfo getInfoByPhone(String s);

}
