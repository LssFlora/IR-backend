package IR.org.core.dao;

import IR.org.core.entity.ReceiptInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author shuangshuang.li
 * @since 2023-04-15
 */
public interface ReceiptInfoMapper extends BaseMapper<ReceiptInfo> {

    int setReceiptInfo(@Param("receiptInfo") ReceiptInfo receiptInfo);
}
