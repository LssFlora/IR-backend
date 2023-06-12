package IR.org.core.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author shuangshuang.li
 * @since 2023-04-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="ReceiptInfo对象", description="")
public class ReceiptInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "收据类型")
    private String receiptType;

    @ApiModelProperty(value = "收据金额")
    private BigDecimal receiptMoney;

    @ApiModelProperty(value = "收据文件")
    private String receiptFile;


}
