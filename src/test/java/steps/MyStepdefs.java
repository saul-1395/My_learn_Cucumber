package steps;


import config.EnvConfig;
import io.cucumber.java.ru.Тогда;
import pages.BasikPage;

import static com.codeborne.selenide.Selenide.open;

public class MyStepdefs {
    BasikPage basikPage = new BasikPage();

    @Тогда("Click {string} button")
    public void clickButton(String string) {

        //  System.out.println("press batton  " + string);

        basikPage.clickButton(string);

    }

    @Тогда("Click {string} button span")
    public void clickButtonSpan(String string) {

        //  System.out.println("press button " + string);
        basikPage.clickButtonSpan(string);

    }

    @Тогда("Content {string} button visible")
    public void contentVisibleButton(String string) {
        //  System.out.println("batton is visible "+ string);
        basikPage.contentVisibleButton(string);

    }

    @Тогда("open {string} page")
    public void openPage(String string) throws InterruptedException {

        open(EnvConfig.URI_LOGIN + string);

    }

    @Тогда("Click {string} button li")
    public void clickButtonLi(String string){
        basikPage.clickButtonLi(string);
    }

    @Тогда("Content class info visible")
    public void contentVisible(){
        basikPage.contentVisible();
    }




}
