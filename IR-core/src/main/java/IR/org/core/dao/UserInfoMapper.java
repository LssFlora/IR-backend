package IR.org.core.dao;

import IR.org.core.entity.UserInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author haoyun.xiong
 * @since 2023-03-20
 */
public interface UserInfoMapper extends BaseMapper<UserInfo> {

     UserInfo getbyUserName(@Param("userName") String userName);
}
