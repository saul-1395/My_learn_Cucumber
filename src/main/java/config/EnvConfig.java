package config;

public class EnvConfig {
    private static final String ENV = "test";
    private static final String USERNAME = "zel-1395@yandex.ru";
    private static final String USERPASSWORD = "123qwertY-123";
    public static final String URI_LOGIN = "https://" + USERNAME + ":" + USERPASSWORD + "@" + ENV + ".grinfer.com/";
    public static String URI_API_LOGIN = "https://" + USERNAME + ":" + USERPASSWORD + "@" + ENV + ".grinfer.com/api/";

}
