package IR.org.core.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.math.BigDecimal;

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
 * @since 2023-04-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="ReimbursementInfo对象", description="")
public class ReimbursementInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "报销单id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "报销单号")
    private String reimbursementNumber;

    @ApiModelProperty(value = "用户id")
    private Long insurantId;

    @ApiModelProperty(value = "收款人名字")
    private String payeeName;

    @ApiModelProperty(value = "性别")
    private Integer payeeSex;

    @ApiModelProperty(value = "电话")
    private String payeePhone;

    @ApiModelProperty(value = "城市")
    private String payeeCity;

    @ApiModelProperty(value = "报销金额")
    private BigDecimal reimbursementAmount;

    @ApiModelProperty(value = "支付方式")
    private Integer paymentMethod;

    @ApiModelProperty(value = "收款账号")
    private String collectionAccount;

    @ApiModelProperty(value = "报销单状态")
    private Integer reimbursementStatus;

    @ApiModelProperty(value = "报销公司")
    private String reimbursementCompany;


}
