package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SigninPage {
    private SelenideElement loginInput = $(By.cssSelector("#email"));
    private SelenideElement passwordInput = $(By.cssSelector("#password"));
    private SelenideElement firstNameInput = $(By.cssSelector("#firstName"));
    private SelenideElement lastNameInput = $(By.cssSelector("#lastName"));


    public void loginInput(String login) {
        this.loginInput.val(login);
    }

    public void passwordInput(String password) {
        this.passwordInput.val(password);
    }

    public void firstNameInput(String firstName) {

        this.firstNameInput.val(firstName);

    }


    public void flastNameInput(String lastName) {
        this.lastNameInput.val(lastName);
    }

    public String getFirstname(){

        return  $(By.cssSelector("#form_firstName")).getValue();
    }

    public String getLastname(){


        return  $(By.cssSelector("#form_lastName")).getValue();
    }

}