package util;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Author : wangeb
 * @Date : 2020/4/10 14:57
 * @Desc :
 */
public class AuthToken {
    private static final long DEFAULT_EXPIRED_TIME_INTERVAL = 1 * 60 * 1000;
    private String token;
    private long createTime;
    private long expiredTimeInterval = DEFAULT_EXPIRED_TIME_INTERVAL;

    public AuthToken(String token, long createTime) {
        this.token = token;
        this.createTime = createTime;
    }

    public AuthToken(String token, long createTime, long expiredTimeInterval) {
        this.token = token;
        this.createTime = createTime;
        this.expiredTimeInterval = expiredTimeInterval;
    }

    public static AuthToken create(String baseUrl, String appId, String password, long createTime) {
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("SHA");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        String str = baseUrl + "&appId=" + appId + "&password=" + password + "&timestamp=" + createTime;
        byte[] bytes = messageDigest.digest(str.getBytes());
        String token = String.valueOf(bytes);
        return new AuthToken(token, createTime);
    }

    public String getToken() {
        return token;
    }

    public boolean isExpired() {
        return createTime + expiredTimeInterval < System.currentTimeMillis();
    }

    public boolean match(AuthToken authToken) {
        return this.token == authToken.token;
    }
}
