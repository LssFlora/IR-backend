package IR.org.common.utils;

import sun.misc.BASE64Decoder;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import java.util.Base64;

import static org.apache.commons.codec.binary.Base64.encodeBase64String;

public class AesUtil {
    private static final String KEY = "0123456789abcdef";
    private static final String IV = "abcdef0123456789";

    public static String encrypt(String plaintext) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec keySpec = new SecretKeySpec(KEY.getBytes(), "AES");
        IvParameterSpec ivSpec = new IvParameterSpec(IV.getBytes());
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);
        byte[] encryptedBytes = cipher.doFinal(plaintext.getBytes("UTF-8"));
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public static String decrypt(String ciphertext) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec keySpec = new SecretKeySpec(KEY.getBytes(), "AES");
        IvParameterSpec ivSpec = new IvParameterSpec(IV.getBytes());
        cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);
        byte[] decodedBytes = Base64.getDecoder().decode(ciphertext);
        byte[] decryptedBytes = cipher.doFinal(decodedBytes);
        return new String(decryptedBytes, "UTF-8");
    }
//    private static final String KEY = "0123456789abcdef";
//    private static final String ALGORITHMSTR = "AES/ECB/PKCS5Padding";
//
//    public static String base64Encode(byte[] bytes) {
//        return encodeBase64String(bytes);
//    }
//
//    public static byte[] base64Decode(String base64Code) throws Exception {
//        return new BASE64Decoder().decodeBuffer(base64Code);
//    }
//
//    public static byte[] aesEncryptToBytes(String content, String encryptKey) throws Exception {
//        KeyGenerator kgen = KeyGenerator.getInstance("AES");
//        kgen.init(128);
//        Cipher cipher = Cipher.getInstance(ALGORITHMSTR);
//        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(encryptKey.getBytes(), "AES"));
//        return cipher.doFinal(content.getBytes("utf-8"));
//    }
//
//    public static String aesEncrypt(String content, String encryptKey) throws Exception {
//        return base64Encode(aesEncryptToBytes(content, encryptKey));
//    }
//
//    public static String aesDecryptByBytes(byte[] encryptBytes, String decryptKey) throws Exception {
//        KeyGenerator kgen = KeyGenerator.getInstance("AES");
//        kgen.init(128);
//        Cipher cipher = Cipher.getInstance(ALGORITHMSTR);
//        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(decryptKey.getBytes(), "AES"));
//        byte[] decryptBytes = cipher.doFinal(encryptBytes);
//        return new String(decryptBytes);
//    }
//
//    public static String aesDecrypt(String encryptStr, String decryptKey) throws Exception {
//        return aesDecryptByBytes(base64Decode(encryptStr), decryptKey);
//    }
}