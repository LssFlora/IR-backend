package IR.org.core.dao;

import IR.org.core.entity.PolicyInfo;
import IR.org.core.vo.*;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author shuangshuang.li
 * @since 2023-04-14
 */
public interface PolicyInfoMapper extends BaseMapper<PolicyInfo> {

    List<viewInfoVo> getCompletedInfo(@Param("str") String str);

    List<viewInfoVo> getProcessingInfo(@Param("str") String str);

    List<viewInfoVo> getEngingInfo();

    List<HistoricalVo> getHistorical(@Param("id") Long id, @Param("date") String date,@Param("name")String name);

    List<HistoricalSelfVo> getHistoricalSelf(@Param("id") Long id, @Param("date") String date, @Param("name") String name);

    int setEvaluationResults(@Param("id") Long id, @Param("status") Integer status, @Param("state") Integer state,@Param("reason")String reason);

    BigDecimal getAmount(@Param("id") Long id);

    void setReimbursementId(@Param("id")Long id,@Param("policyId")Long policyId);

    OverviewVo getOverViewInfo(@Param("id") Long id);

    int setRegisterInfo(@Param("data") PolicyInfo policInfo);

    ReceiptInfoVo getReceiptInfo(@Param("id")Long id);

    OverviewVo getOverViewInfo1(@Param("id")Long id);

    int getInsureType(Long id);

    int countPolicyInfo(Long id);
}
