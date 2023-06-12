package IR.org.core.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class ReceiptInfoVo implements Serializable {
    @ApiModelProperty(value = "收据类型")
    private String receiptType;

    @ApiModelProperty(value = "收据金额")
    private BigDecimal receiptMoney;
}