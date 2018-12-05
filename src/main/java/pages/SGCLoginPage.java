package pages;

import exceptions.PageNotLoadedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class SGCLoginPage extends SGCBasePage {
    @FindBy(id = "userId")
    public WebElement userNameField;
    @FindBy(id = "password")
    public WebElement userPasswordField;
    @FindBy(className = "loginButton")
    public WebElement loginButton;
    @FindBy(id = "loginForm")
    public WebElement loginForm;


    public SGCLoginPage(WebDriver webDriver) {
        super(webDriver);
    }


    public HomePage logIn(String userName, String password) {
        userNameField.sendKeys(userName);
        userPasswordField.sendKeys(password);
        loginButton.click();
        return new HomePage(webDriver);

    }

    public SGCLoginPage openPage() throws InterruptedException, PageNotLoadedException {
        webDriver.get("https://newqa-safeguard.openq.net/");
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // implicit wait instead of  Thread.sleep(5000)
        if (this.isDisplayed()) {
            return new SGCLoginPage(webDriver);
        } else throw new PageNotLoadedException("Login Page is not loaded");

    }

    public boolean isDisplayed() {
        return loginForm.isDisplayed();


    }


}
