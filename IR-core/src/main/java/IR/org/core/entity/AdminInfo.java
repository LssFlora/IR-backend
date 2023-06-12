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
@ApiModel(value="AdminInfo对象", description="")
public class AdminInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "账号")
    private String accountNumber;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "权限,默认0无权限，1.登记 2.评估 3.报销,4.管理员")
    private String authority;

    @ApiModelProperty(value = "已处理保单id")
    private String processedPolicyId;
}
