package IR.org.core.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Data
public class HistoricalVo {
    @JsonFormat(pattern="yyyy-MM-dd", timezone = "GMT+8")
    @ApiModelProperty(value = "申请报销时间")
    private Date declarationTime;

    @ApiModelProperty(value = "事件描述")
    private String eventDescription;

    @ApiModelProperty(value = "报销金额")
    private BigDecimal reimbursementAmount;

    @ApiModelProperty(value = "报销公司")
    private String reimbursementCompany;
}
