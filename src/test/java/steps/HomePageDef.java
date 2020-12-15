package steps;

import io.cucumber.java.ru.Тогда;
import pages.HomePage;

public class HomePageDef {

    HomePage homePage = new HomePage();

    @Тогда("Click Avatar button")
    public void clickAvatarButton() {
            homePage.avatarButton.click();
    }
}
