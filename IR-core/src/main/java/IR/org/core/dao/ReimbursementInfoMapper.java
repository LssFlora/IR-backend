package IR.org.core.dao;

import IR.org.core.entity.ReimbursementInfo;
import IR.org.core.vo.ReimbursementVo;
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
public interface ReimbursementInfoMapper extends BaseMapper<ReimbursementInfo> {

    int setReimbursementInfo(@Param("data") ReimbursementInfo reimbursement);
}
