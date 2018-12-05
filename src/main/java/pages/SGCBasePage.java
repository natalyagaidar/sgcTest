package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SGCBasePage {
    protected WebDriver webDriver;
    public SGCBasePage(){}

    public SGCBasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void openPage(String url) {
        webDriver.get(url);
    }
}
