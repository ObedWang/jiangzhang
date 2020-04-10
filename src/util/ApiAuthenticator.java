package util;

/**
 * @Author : wangeb
 * @Date : 2020/4/10 15:13
 * @Desc : oauth接口暴露类
 */
public interface ApiAuthenticator {
    /**
     * 验证该url token 是否正确
     *
     * @param url url
     */
    void auth(String url);

    /**
     * 验证该url token 是否正确
     *
     * @param apiRequest apiRequest
     */
    void auth(ApiRequest apiRequest);
}
