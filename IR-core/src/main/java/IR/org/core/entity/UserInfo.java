package IR.org.core.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author haoyun.xiong
 * @since 2023-03-20
 */
@Data
//@EqualsAndHashCode(callSuper = false)
@ApiModel(value="UserInfo对象", description="用户表")
@TableName("user_info")
public class UserInfo implements Serializable {
    private static final long serialVersionUID = -40356785423868312L;
    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "用户名")
    private String userName;

    @ApiModelProperty(value = "昵称")
    private String nickName;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "账号状态（0正常 1停用）")
    private Integer status;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "手机号")
    private String phoneNumber;

    @ApiModelProperty(value = "用户性别（0男，1女，2未知）")
    private Integer sex;

    @ApiModelProperty(value = "头像")
    private String avatar;

    @ApiModelProperty(value = "用户类型（0管理员，1普通用户，2实名用户）")
    private String userType;

    @ApiModelProperty(value = "创建人的用户id")
    private Long createBy;

    @TableField(fill= FieldFill.INSERT)
    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern="yyyy-MM-dd", timezone = "GMT+8")
    private Date createTime;


    @ApiModelProperty(value = "更新人")
    private Long updateBy;

    @TableField(fill= FieldFill.INSERT_UPDATE)
    @ApiModelProperty(value = "更新时间")
    @JsonFormat(pattern="yyyy-MM-dd", timezone = "GMT+8")
    private Date updateTime;

    @ApiModelProperty(value = "删除标志（0代表未删除，1代表已删除）")
    private Integer delFlag;

    @ApiModelProperty(value = "身份证")
    private String identityCard;

}
