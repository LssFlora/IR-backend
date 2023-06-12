package IR.org.core.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class OverviewVo {
    @ApiModelProperty(value = "保单id")
    private Long id;

    @ApiModelProperty(value = "保单号")
    private String policyNumber;

    @ApiModelProperty(value = "医院名")
    private String hospitalName;

    @ApiModelProperty(value = "指定医院状态 0.否 1.是")
    private Integer designatedHospitalStatus;

    @ApiModelProperty(value = "住院状态 0.未 1.已")
    private Integer hospitalizationStatus;

    @ApiModelProperty(value = "申请报销时间")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date declarationTime;

    @ApiModelProperty(value = "事件描述")
    private String eventDescription;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "性别（0.女，1.男）")
    private Integer sex;

    @ApiModelProperty(value = "手机号")
    private String phone;

    @ApiModelProperty(value = "身份证")
    private String identityCard;

    @ApiModelProperty(value = "居住城市")
    private String city;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @ApiModelProperty(value = "出生日期")
    private Date dateOfBirth;

    @ApiModelProperty(value = "医保类型")
    private Integer insureType;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @ApiModelProperty(value = "参保时间")
    private Date insurancePeriod;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @ApiModelProperty(value = "过期时间")
    private Date expirationTime;

    @ApiModelProperty(value = "报销单号")
    private String reimbursementNumber;

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

    @ApiModelProperty(value = "报销公司")
    private String reimbursementCompany;

    private String reason;

    private String evaluationStatus;

    private ReceiptInfoVo receiptInfo;
}
