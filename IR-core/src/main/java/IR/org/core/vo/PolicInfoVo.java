package IR.org.core.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class PolicInfoVo implements Serializable {
    @ApiModelProperty(value = "受保人id")
    private Long insurantId;

    @ApiModelProperty(value = "医院名")
    private String hospitalName;

    @ApiModelProperty(value = "指定医院状态 0.否 1.是")
    private Integer designatedHospitalStatus;

    @ApiModelProperty(value = "住院状态 0.未 1.已")
    private Integer hospitalizationStatus;

//    @ApiModelProperty(value = "申请报销时间")
//    @JsonFormat(pattern="yyyy-MM-dd", timezone = "GMT+8")
//    private Date declarationTime;

    @ApiModelProperty(value = "事件描述")
    private String eventDescription;

    @ApiModelProperty(value = "收据信息")
    private ReceiptInfoVo[] receiptInfoVoList;

//    @ApiModelProperty(value = "收据附件")
//    private MultipartFile[] file;

    //保存还是提交 0.保存 1.提交
    private int status;
}
