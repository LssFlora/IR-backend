package IR.org.core.entity;

import java.math.BigDecimal;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
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
@ApiModel(value="PolicyInfo对象", description="")
public class PolicyInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "保单id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "受保人id")
    private Long insurantId;

    @ApiModelProperty(value = "报销单id")
    private Long reimbursementId;

    @ApiModelProperty(value = "收据id")
    private String ReceiptId;

    @ApiModelProperty(value = "保单号")
    private String policyNumber;

    @ApiModelProperty(value = "医院名")
    private String hospitalName;

    @ApiModelProperty(value = "指定医院状态 0.否 1.是")
    private Integer designatedHospitalStatus;

    @ApiModelProperty(value = "住院状态 0.未 1.已")
    private Integer hospitalizationStatus;

    @ApiModelProperty(value = "申请报销时间")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date declarationTime;

    @ApiModelProperty(value = "事件描述")
    private String eventDescription;

    @ApiModelProperty(value = "保单状态 1.登记状态 2.评估状态 3.报销登记状态 4.完成 5.评估失败")
    private Integer policyStatus;

    @ApiModelProperty(value = "评估状态 0.未通过 1.通过")
    private Integer evaluationStatus;

    @ApiModelProperty(value = "评估不通过原因")
    private String reason;
}
