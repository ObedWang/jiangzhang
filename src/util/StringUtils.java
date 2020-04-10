package util;

/**
 * @Author : wangeb
 * @Date : 2020/4/10 17:17
 * @Desc :
 */
public class StringUtils {

    public static boolean isEmpty(String str) {
        return str == null || str.trim().length() == 0;
    }
}
