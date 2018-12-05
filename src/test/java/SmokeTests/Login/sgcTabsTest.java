package SmokeTests.Login;

import Utilities.GoToTabsMatcher;
import Utilities.TabsMatcher;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.HomePage;
import pages.MenuTabs;
import pages.SGCLoginPage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class sgcTabsTest {
    WebDriver webDriver;
    private String SGCUrl = "https://newqa-safeguard.openq.net/";
    private MenuTabs menuTabs;
    private SGCLoginPage loginPage;
    private HomePage homePage;
    private List<String> tabNames;

    @BeforeMethod
    public void setUp() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "chromedriver_win32/chromedriver.exe");
        // DesiredCapabilities capabilities=DesiredCapabilities.chrome();
        webDriver = new ChromeDriver(); //new remote driver, capabilities, create separate class for it, in class getLocal browser, get Remote browser
        loginPage = new SGCLoginPage(webDriver)
                .openPage();

    }

    @Test(dataProvider = "credentials")
    public void allTabsArePresentTest(String username, String password, List<String> tabNames) throws InterruptedException {
        homePage = loginPage.logIn(username, password);
        menuTabs = homePage.getMenuTabs();
        assertThat(menuTabs, TabsMatcher.matchTabs(tabNames));

    }

    @Test(dataProvider = "credentials")
    public void goToTabsOneByOneTest(String username, String password, List<String> tabNames) throws InterruptedException {
        homePage = loginPage.logIn(username, password);
        menuTabs = homePage.getMenuTabs();
        Assert.assertTrue(menuTabs.clickAllTabs(tabNames));//DONE each time being on the next  page click on tab wait page loaded
        //assertThat(menuTabs , GoToTabsMatcher.canClickTabs(tabNames));

    }

    @AfterMethod
    public void tearDown() {
        webDriver.close();
    }

    @DataProvider(name = "credentials")
    public Object[][] credentials() {
        Object[][] credentials = {{"natagaidar","Tester123", Arrays.asList("Home", "Archive", "Profiles", "Defend","Insights" ,"Admin")}
        ,{"natashaga", "Tester123",Arrays.asList("Home", "Archive", "Profiles", "Insights" ,"Admin")},
        {"yukr_nata", "Tester123", Arrays.asList("Home", "Archive", "Profiles", "Insights" )}}; //DONE 3d parameter - list of tabs
        return credentials;

    }

}
