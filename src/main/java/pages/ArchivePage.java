package pages;

import exceptions.PageNotLoadedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class ArchivePage extends SGCBasePageAuthorized {
    @FindBy(className = "messagesArchiveLabel")
    public WebElement messagesArchiveLabel;

    public ArchivePage(WebDriver webDriver) {
        super(webDriver);
    }

    public ArchivePage openPage() throws InterruptedException, PageNotLoadedException {
        webDriver.get("https://newqa-safeguard.openq.net/safeguard/enhancedDashboard/dashboard.htm#pane_id=archive");
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // !!! EXPLICIT move to isDisplayed
        if (this.isDisplayed()) {
            return new ArchivePage(webDriver);
        } else throw new PageNotLoadedException("Archive Page is not loaded");

    }

    public boolean isDisplayed() { // create abstract method + explicit wait
        return messagesArchiveLabel.isDisplayed();


    }
}
