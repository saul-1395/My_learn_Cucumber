package impl;

import config.EnvConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import lombok.var;
import models.API.User;
import services.AuthService;

import static app_context.RunContext.put;
import static io.restassured.RestAssured.given;

public class AuthServiceImpl implements AuthService {
    private final String SERVICE = "auth/";

    @Override
    public User createUser(User user) {
        String urlauto = EnvConfig.URI_API_LOGIN+SERVICE;
        String url = "https://test.grinfer.com/api/auth/create";
        System.out.println(urlauto);
        Response r = given().
                contentType(ContentType.JSON).
                body(user).
                post(url);

        System.out.println(r.statusCode());
        System.out.println("**********************************************************");
        r.print();

        System.out.println(r.toString());
        if (r.statusCode() == 200) {

            return r.as(User.class);             //делаем каст из Response в User
        }
        return null;
    }

    @Override
    public User loginUser(User user) {
        String url = "https://test.grinfer.com/api/auth/login";
        System.out.println(url);
        Response r = given().
                contentType(ContentType.JSON).
                body(user).
                post(url);


        if (r.statusCode() == 200) {
            var cookies =  r.getCookies();
            put("cookies", cookies);
            put("user", r.as(User.class));
            return r.as(User.class);
        }
        return null;
    }
}
