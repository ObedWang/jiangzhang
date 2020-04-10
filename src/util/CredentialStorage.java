package util;

/**
 * @Author : wangeb
 * @Date : 2020/4/10 14:57
 * @Desc : appId 和 password 获取类
 */
public interface CredentialStorage {
    /**
     * 通过appId获取对应密码
     *
     * @param appId appId
     * @return string
     */
    String getPasswordByAppId(String appId);
}
