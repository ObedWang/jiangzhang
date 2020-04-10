package util;

/**
 * @Author : wangeb
 * @Date : 2020/4/10 14:57
 * @Desc :
 */
public class ApiRequest {
    private String baseUrl;
    private String token;
    private String appId;
    private long timestamp;

    public ApiRequest(String baseUrl, String token, String appId, long timestamp) {
        this.baseUrl = baseUrl;
        this.token = token;
        this.appId = appId;
        this.timestamp = timestamp;
    }

    /**
     * 简单写的处理full url的方法 当然这个方法其实还有很多问题
     *
     * @param url url
     * @return api request
     */
    public static ApiRequest createFromFullUrl(String url) {
        String[] strs = url.split("&");
        String baseUrl = strs[0], token = null, appId = null, timestamp = null;
        for (String str : strs) {
            if (str.contains("token")) {
                token = str.split("token=")[1];
            } else if (str.contains("appId")) {
                appId = str.split("appId=")[1];
            } else if (str.contains("timestamp")) {
                timestamp = str.split("timestamp=")[1];
            }
        }
        if (StringUtils.isEmpty(baseUrl) || StringUtils.isEmpty(token) || StringUtils.isEmpty(appId) || StringUtils.isEmpty(timestamp)) {
            throw new RuntimeException("missing params");
        }
        return new ApiRequest(baseUrl, token, appId, Long.parseLong(timestamp));
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public String getToken() {
        return token;
    }

    public String getAppId() {
        return appId;
    }

    public long getTimestamp() {
        return timestamp;
    }
}
