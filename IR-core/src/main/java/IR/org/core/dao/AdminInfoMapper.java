package IR.org.core.dao;

import IR.org.core.entity.AdminInfo;
import IR.org.core.entity.UserInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author shuangshuang.li
 * @since 2023-04-14
 */
public interface AdminInfoMapper extends BaseMapper<AdminInfo> {

    AdminInfo getByAddminAccount(@Param("account") String account);

    void addProcessedPolicyId(@Param("id") Long id,@Param("policy_id") String policy_id);
}
