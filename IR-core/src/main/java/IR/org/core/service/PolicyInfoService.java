package IR.org.core.service;

import IR.org.common.utils.R;
import IR.org.core.entity.PolicyInfo;
import IR.org.core.vo.PolicInfoVo;
import IR.org.core.vo.ReimbursementVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.time.LocalDateTime;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author shuangshuang.li
 * @since 2023-04-14
 */
public interface PolicyInfoService extends IService<PolicyInfo> {

    R setRegisterInfo(PolicInfoVo infoVo);

    R getProcessingInfo();

    R getCompletedInfo();

    R getEngingInfo();

    R getHistorical(Long id, String date);

    R getHistoricalSelf(Long id, String date);

    R setEvaluationResults(Long id, Integer status,String reason);

    R getAmount(Long id);

    R setReimbursement(ReimbursementVo info);

    R getOverViewInfo(Long id);

    R getPolicyInfo(Long id);
}
