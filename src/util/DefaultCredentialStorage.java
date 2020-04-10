package util;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author : wangeb
 * @Date : 2020/4/10 15:16
 * @Desc :
 */
public class DefaultCredentialStorage implements CredentialStorage {

    private Map<String, String> defaultData;

    public DefaultCredentialStorage() {
        defaultData = new HashMap<>();
        defaultData.put("abc", "123");
        defaultData.put("cba", "456");
    }

    @Override
    public String getPasswordByAppId(String appId) {
        String str = defaultData.get(appId);
        if (str == null) {
            throw new RuntimeException("no such app id");
        }
        return str;
    }
}
