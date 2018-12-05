package SmokeTests.Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SGCLoginPage;

import java.util.List;

public class sgcLoginTest {
    WebDriver webDriver;
    private String SGCUrl = "https://newqa-safeguard.openq.net/";

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "chromedriver_win32/chromedriver.exe");
       // DesiredCapabilities capabilities=DesiredCapabilities.chrome();
        webDriver = new ChromeDriver();
    }

    @Test
    public void LoginTest() throws InterruptedException {

        SGCLoginPage loginPage = new SGCLoginPage(webDriver);
        loginPage.openPage(SGCUrl);
        Thread.sleep(5000);
        HomePage homePage = loginPage.logIn("natagaidar", "Tester1234");
        Assert.assertNotNull(homePage.getMenuTabs());
    }

    @AfterClass
    public void tearDown(){
        webDriver.close();
    }

}
