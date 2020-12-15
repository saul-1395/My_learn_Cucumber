package steps;

import config.UserConfig;
import impl.AuthServiceImpl;
import io.cucumber.java.en.Then;
import io.cucumber.java.ru.Тогда;
import models.API.User;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import pages.SigninPage;
import services.AuthService;

import static app_context.RunContext.get;
import static app_context.RunContext.put;

public class SignInPageDef {

    SigninPage signinPage = new SigninPage();
    AuthService authService = new AuthServiceImpl();

    @Тогда("Input email")
    public void inputLogin() {
        String email = "Auto_" + RandomStringUtils.randomAlphabetic(5) + "@mail.com";
        signinPage.loginInput(email);
        put("email", email);

    }

    @Тогда("Input first name")
    public void inputFirstName() {
        String firstname = UserConfig.USER_FIRSTNAME;
        signinPage.firstNameInput(firstname);
        put("firstname", firstname);

    }

    @Тогда("Input last name")
    public void inputLastName() {
        String lastname = UserConfig.USER_LASTNAME;
        signinPage.flastNameInput(lastname);
        put("lastname", lastname);
    }


    @Тогда("Input password")
    public void inputPassword() {
        signinPage.passwordInput(UserConfig.USER_PASSWORD);
    }


    @Тогда("Check firstName field")
    public void checkFirstName() {
        String expected = get("firstname", String.class);
        String actual = signinPage.getFirstname();
        System.out.println("***** " + expected + "    " + actual);
        Assert.assertEquals(expected, actual);
    }

    @Тогда("Check lastName field")
    public void checkLastName() {
        String expected = get("lastname", String.class);
        String actual = signinPage.getLastname();
        System.out.println("***** " + expected + "    " + actual);
        Assert.assertEquals(expected, actual);
    }

    @Then("Create user by api")
    public void createUserByApi() {

        User newUser = User.builder().
                email("test_mail_" + RandomStringUtils.randomAlphabetic(5) + "@mail.com")
                .fast(true)
                .anonymous(false)
                .firstName(UserConfig.USER_FIRSTNAME)
                .lastName(UserConfig.USER_LASTNAME)
                .password(UserConfig.USER_PASSWORD)
                .rememberMe(true)
                .build();

        put("user", newUser);
        User createUser = authService.createUser(newUser);

        Assert.assertNotNull(createUser);

        Assert.assertEquals(createUser.getEmail().toLowerCase(), newUser.getEmail().toLowerCase());

        Assert.assertNotNull(createUser.getId());


    }

    @Then("Login user by api")
    public void loginUserByApi() {

        User user = get("user", User.class);
        User loginUser = authService.loginUser(user);
         Assert.assertEquals(user.getEmail().toLowerCase(), loginUser.getEmail().toLowerCase());

         if((user.getEmail().toLowerCase()).equals( loginUser.getEmail().toLowerCase())){


         }
    }
}

