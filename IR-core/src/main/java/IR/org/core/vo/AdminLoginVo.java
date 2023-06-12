package IR.org.core.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class AdminLoginVo implements Serializable {
    private String userName;
    private String code;
    private String password;
}
