package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class HomePage {
    public SelenideElement avatarButton = $(By.xpath("//span[contains(@class, 'ant-avatar')]/.."));


}
