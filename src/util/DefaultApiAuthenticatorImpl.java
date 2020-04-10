package util;


/**
 * @Author : wangeb
 * @Date : 2020/4/10 15:14
 * @Desc :
 */
public class DefaultApiAuthenticatorImpl implements ApiAuthenticator {
    private CredentialStorage credentialStorage;

    public DefaultApiAuthenticatorImpl() {
        credentialStorage = new DefaultCredentialStorage();
    }

    public DefaultApiAuthenticatorImpl(CredentialStorage credentialStorage) {
        this.credentialStorage = credentialStorage;
    }

    @Override
    public void auth(String url) {
        ApiRequest apiRequest = ApiRequest.createFromFullUrl(url);
        auth(apiRequest);
    }

    @Override
    public void auth(ApiRequest apiRequest) {
        String appId = apiRequest.getAppId();
        String token = apiRequest.getToken();
        long timestamp = apiRequest.getTimestamp();
        String baseUrl = apiRequest.getBaseUrl();
        AuthToken clientAuthToken = new AuthToken(token, timestamp);
        if (clientAuthToken.isExpired()) {
            throw new RuntimeException("Token is expired.");
        }
        String password = credentialStorage.getPasswordByAppId(appId);
        AuthToken serverAuthToken = AuthToken.create(baseUrl, appId, password, timestamp);
        if(!serverAuthToken.match(clientAuthToken)){
            throw new RuntimeException("Token verification failed.");
        }
    }
}
