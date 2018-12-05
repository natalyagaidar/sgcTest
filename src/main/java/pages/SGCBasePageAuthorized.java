package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SGCBasePageAuthorized {
    protected WebDriver webDriver;
    public MenuTabs menuTabs;


    public SGCBasePageAuthorized(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void openPage(String url) {
        webDriver.get(url);
    }
}
