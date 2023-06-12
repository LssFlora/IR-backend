package IR.org.common.utils;

import org.springframework.security.crypto.password.PasswordEncoder;

public class MyPasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence charSequence) {
        try {
            return AesUtil.encrypt((String)charSequence);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        try {
            return charSequence.equals(AesUtil.decrypt(s));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
