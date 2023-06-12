package IR.org.core.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author haoyun.xiong
 * @since 2023-04-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="UserAddressInfo对象", description="")
public class UserAddressInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long userId;

    private String liaisonMan;

    private String address;

    private Integer phoneNumber;

    private String status;

    private String sex;


}
