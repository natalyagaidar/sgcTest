package pages;

import com.google.common.collect.Lists;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.ArrayList;
import java.util.List;

public class MenuTabs {

    private WebDriver webDriver;
    private Tab homeTab; // DONE MOVE to constructor
    private Tab archiveTab;
    private Tab profileTab;
    private Tab defendTab;
    private Tab insightsTab;
    private Tab adminTab;
    private Tab threatsTab;


    //@FindBy(id = "menu")
    public WebElement menuTab;

    public MenuTabs(WebDriver webDriver) {
        this.webDriver = webDriver;
        //PageFactory.initElements(webDriver, this);
        homeTab = new Tab("homeTab", webDriver);
        archiveTab = new Tab("archiveTab", webDriver);
        profileTab = new Tab("profileTab", webDriver);
        defendTab = new Tab("defendTab", webDriver);
        insightsTab = new Tab("insightsTab", webDriver);
        archiveTab = new Tab("adminTab", webDriver);
        threatsTab = new Tab("threatsTab", webDriver);
        menuTab = webDriver.findElement(By.id("menu"));

    }

    public ArchivePage openArchivePage() {
        archiveTab.click();
        return new ArchivePage(webDriver);
    }

    public List<WebElement> getMenuTabsList() {
        return this.menuTab.findElements(By.className("parent"));
    }

    public SGCBasePageAuthorized clickMenuItem(WebElement menuTab) {
        menuTab.click();
        return new SGCBasePageAuthorized(webDriver);

    }

    public boolean clickTabWaitPageLoaded(WebElement menuTab) {
        menuTab.click();
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        boolean isPageLoaded = false;

        for (int i = 0; i < 25; i++) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {

            }
            if (js.executeScript("return document.readyState").toString().equals("complete")) {
                isPageLoaded = true;
                break;
            }
        }
        return isPageLoaded;

    }

    public boolean clickAllTabs(List<String> tabNames) throws InterruptedException {//parameter - list of expected tabs instead of findElements
        WebDriverWait wait = new WebDriverWait(webDriver, 60);
        WebElement expectedTab;
        boolean clickedAllTabs = false;
        List<WebElement> actualTabs = menuTab.findElements(By.className("parent"));
        List<String> actualTabNames = new ArrayList<String>();
        for (WebElement element : actualTabs) {
            if (!element.getText().contains("Welcome"))
                actualTabNames.add(element.getText());
        }
        if (tabNames.equals(actualTabNames)) {
            for (String element : Lists.reverse(tabNames)
                    ) {
                if ((element.equals("Profiles"))
                        || (element.equals("Defend"))) {
                    continue;
                }
//                expectedTab = wait.until(ExpectedConditions.elementToBeClickable(By.linkText(element)));
                Thread.sleep(5000);
                clickedAllTabs = clickTabWaitPageLoaded(this.menuTab.findElement(By.linkText(element))); // check visibility on the page
                if (clickedAllTabs == false) return clickedAllTabs;
            }
        }
        return clickedAllTabs;
    }
}

