package test;

import util.ApiAuthenticator;
import util.ApiRequest;
import util.DefaultApiAuthenticatorImpl;

/**
 * @Author : wangeb
 * @Date : 2020/4/10 17:31
 * @Desc :
 */
public class Main {
    public static void main(String[] args) {
        ApiAuthenticator apiAuthenticator = new DefaultApiAuthenticatorImpl();
        apiAuthenticator.auth("127.0.0.1:8080/api/user/get?userId=1&appId=abc&token=123&timestamp=1586511424509");
//        System.out.println(System.currentTimeMillis());
    }
}
