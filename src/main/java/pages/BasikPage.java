package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class BasikPage {

    public void clickButton(String text) {

        $(By.xpath("//div[text()='" + text + "']")).click();


    }

    public void clickButtonSpan(String text) {

        $(By.xpath("//span[text()='" + text + "']/..")).click();

    }

    public void contentVisibleButton(String text) {
        $(By.xpath("//div[text()='" + text + "']")).shouldBe(Condition.visible);


    }

    public void clickButtonLi(String text) {
        $(By.xpath("//li[text()='" + text + "']/..")).click();
    }

    public void contentVisible() {
        $("//span[@class='info']");
    }
}
