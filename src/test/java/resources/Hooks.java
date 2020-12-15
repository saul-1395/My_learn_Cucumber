package resources;


import com.codeborne.selenide.WebDriverRunner;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {


    @Before
    public void openUrl() throws InterruptedException {
       System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Documents\\mylearnCucumber\\src\\main\\resources\\Chrome.exe");
        WebDriver driver= new ChromeDriver();

        WebDriverRunner.setWebDriver(driver);

       // open("https://test.grinfer.com/");

    }


}
