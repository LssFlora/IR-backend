package IR.org.common.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;
import java.util.UUID;

/**
 * JWT工具类
 */
public class JwtUtil {

    //有效期为
    public static final Long JWT_TTL = 7 * 24 * 60 * 60 *1000L;// 60 * 60 *1000  一个小时
    //设置秘钥明文
    public static final String JWT_KEY = "haoyun.xiong";
    public static final String JWT_SIGN = "HS256";


    public static String getUUID(){
        String token = UUID.randomUUID().toString().replaceAll("-", "");
        return token;
    }

    /**
     * 生成jtw
     * @param username token中要存放的数据（json格式）
     * @return
     */
    public static String createJWT(String username) {
        JwtBuilder builder = getJwtBuilder(username, null, getUUID());// 设置过期时间
        return builder.compact();
    }

    public static String createJWT(String username,String id,Long ttlMillis) {
        JwtBuilder builder = getJwtBuilder(username, null, id);// 设置过期时间
        return builder.compact();
    }

    /**
     * 生成jtw
     * @param username token中要存放的数据（json格式）
     * @param ttlMillis token超时时间
     * @return
     */
    public static String createJWT(String username, Long id) {
        JwtBuilder builder = getJwtBuilder(username, null, String.valueOf(id));// 设置过期时间
        return builder.compact();
    }

    private static JwtBuilder getJwtBuilder(String username, Long ttlMillis, String id) {
        SecretKey secretKey = generalKey();
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        if(ttlMillis==null){
            ttlMillis=JwtUtil.JWT_TTL;
        }
        long expMillis = nowMillis + ttlMillis;
        Date expDate = new Date(expMillis);
        System.out.println(expDate+"~~~~~"+now);
        return Jwts.builder()
                .setId(id)              //唯一的ID
                .setSubject(username)   // 主题  可以是JSON数据
                .setIssuer("haoyun.xiong")     // 签发者
                .setIssuedAt(now)      // 签发时间
                .signWith(SignatureAlgorithm.HS256, secretKey) //使用HS256对称加密算法签名, 第二个参数为秘钥
                .setExpiration(expDate);
    }



    /**
     * 创建token
     * @param id
     * @param username
     * @param ttlMillis
     * @return
     */

    /**
     * 生成加密后的秘钥 secretKey
     * @return
     */
    public static SecretKey generalKey() {
        SecretKey key = new SecretKeySpec(JWT_KEY.getBytes(),SignatureAlgorithm.HS256.getJcaName());
        return key;
    }

//    public static SecretKey degeneralKey() {
//        byte[] decodedKey = Base64.getDecoder().decode(JWT_KEY.getBytes());
//        SecretKey key = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");
//        return key;
//    }

    /**
     * 解析
     *
     * @param jwt
     * @return
     * @throws Exception
     */
    public static Claims parseJWT(String jwt) throws Exception {
        SecretKey secretKey = generalKey();
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(jwt)
                .getBody();
    }
}
