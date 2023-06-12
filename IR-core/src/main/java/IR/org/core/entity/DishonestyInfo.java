package IR.org.core.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="DishonestyInfo对象", description="")
public class DishonestyInfo implements Serializable {

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private int id;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dishonestyTime;
    private String dishonestyReason;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date releaseTime;
    private int dishonestyType;
    private Long insuredUserId;

}
