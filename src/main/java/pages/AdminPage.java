package pages;

import exceptions.PageNotLoadedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class AdminPage extends SGCBasePageAuthorized {
    @FindBy(className = "dijitTreeLabel")
    public WebElement clientNode;

    public AdminPage(WebDriver webDriver) {
        super(webDriver);
    }

    public AdminPage openPage() throws InterruptedException, PageNotLoadedException {
        webDriver.get("https://newqa-safeguard.openq.net/safeguard/enhancedDashboard/dashboard.htm#pane_id=admin");
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // implicit wait instead of  Thread.sleep(5000)
        if (this.isDisplayed()) {
            return new AdminPage(webDriver);
        } else throw new PageNotLoadedException("Admin Page is not loaded");

    }

    public boolean isDisplayed() {
        return clientNode.isDisplayed();


    }

}
