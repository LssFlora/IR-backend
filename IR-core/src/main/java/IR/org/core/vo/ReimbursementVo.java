package IR.org.core.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ReimbursementVo {

    @ApiModelProperty(value = "保单id")
    private Long policyId;

    @ApiModelProperty(value = "用户id")
    private Long insurantId;

    @ApiModelProperty(value = "收款人名字")
    private String payeeName;

    @ApiModelProperty(value = "性别")
    private Integer sex;

    @ApiModelProperty(value = "电话")
    private String phone;

    @ApiModelProperty(value = "城市")
    private String city;

    @ApiModelProperty(value = "报销金额")
    private BigDecimal reimbursementAmount;

    @ApiModelProperty(value = "支付方式")
    private Integer paymentMethod;

    @ApiModelProperty(value = "收款账号")
    private String collectionAccount;


}
