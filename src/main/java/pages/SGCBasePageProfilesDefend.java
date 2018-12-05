package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SGCBasePageProfilesDefend {
    protected WebDriver webDriver;
    public MenuTabs menuTabs;


    public SGCBasePageProfilesDefend(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void openPage(String url) {
        webDriver.get(url);
    }
}
