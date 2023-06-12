package IR.org.core;

import IR.org.common.utils.AesUtil;
import cn.hutool.crypto.digest.DigestUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@SpringBootTest
class GulimallMemberApplicationTests {
    private String s = "U2FsdGVkX1/vo29IThpcX0pE+uaHtCKlPhEMxw4WvYQ=";

    @Test
    void contextLoads() throws Exception {
        String abc = AesUtil.encrypt("123456");
        System.out.println(AesUtil.decrypt(abc));
        System.out.println(abc);
    }

}
