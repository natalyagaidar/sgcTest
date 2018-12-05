package pages;

import exceptions.PageNotLoadedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class HomePage extends SGCBasePageAuthorized {
    @FindBy(className = "policyViolationLabel")
    public WebElement policyViolationLabel;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public MenuTabs getMenuTabs() {
        //return PageFactory.initElements(webDriver, MenuTabs.class);
        return new MenuTabs(webDriver);
    }

    public ArchivePage openPage() throws InterruptedException, PageNotLoadedException {
        webDriver.get("https://newqa-safeguard.openq.net/safeguard/enhancedDashboard/dashboard.htm#pane_id=home");
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // implicit wait instead of  Thread.sleep(5000) TODO explicit wait
        if (this.isDisplayed()) {
            return new ArchivePage(webDriver);
        } else throw new PageNotLoadedException("Home Page is not loaded");

    }

    public boolean isDisplayed() {
        return policyViolationLabel.isDisplayed();
    }
}
