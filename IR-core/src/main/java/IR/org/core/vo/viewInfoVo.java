package IR.org.core.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class viewInfoVo {
    @ApiModelProperty(value = "保单id")
    private Long id;

    private Long insurantId;

    @ApiModelProperty(value = "受保人姓名")
    private String name;

    @ApiModelProperty(value = "受保人电话")
    private String phone;

    @ApiModelProperty(value = "受保人身份证")
    private String identityCard;

    @ApiModelProperty(value = "申请报销时间")
    @JsonFormat(pattern="yyyy-MM-dd", timezone = "GMT+8")
    private Date declarationTime;

    @ApiModelProperty(value = "保单状态 1.登记状态 2.评估状态 3.报销登记状态 4.完成 5.评估失败")
    private Integer policyStatus;

    @ApiModelProperty(value = "医保类型")
    private Integer insureType;

    private String reason;

}
