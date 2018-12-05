package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MenuTabsProfilesDefend {
    private WebDriver webDriver;
    private Tab homeTab;
    private Tab archiveTab;
    private Tab profileTab;
    private Tab defendTab;
    private Tab insightsTab;
    private Tab adminTab;
    private Tab threatsTab;


    //@FindBy(id = "menu")
    public WebElement menuTabProfilesDefend;

    public MenuTabsProfilesDefend(WebDriver webDriver) {
        this.webDriver = webDriver;
        //PageFactory.initElements(webDriver, this);
        homeTab = new Tab("homeTab", webDriver);
        archiveTab = new Tab("archiveTab", webDriver);
        profileTab = new Tab("profileTab", webDriver);
        defendTab = new Tab("defendTab", webDriver);
        insightsTab = new Tab("insightsTab", webDriver);
        archiveTab = new Tab("adminTab", webDriver);
        threatsTab = new Tab("threatsTab", webDriver);
        menuTabProfilesDefend = webDriver.findElement(By.className("header__navigation-list hidden "));

    }

    public List<WebElement> getMenuTabs() {
        return this.menuTabProfilesDefend.findElements(By.className("navigation-list__element"));
    }

    public SGCBasePageAuthorized clickMenuItem(WebElement menuTab) {
        menuTab.click();
        return new SGCBasePageAuthorized(webDriver);

    }

    public boolean isLoadedPageClicked(WebElement menuTab) {
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

    public DefendPage proceedToDefendTab(){
        for (int i=0; i< this.getMenuTabs().size(); i++ ){
            if(this.getMenuTabs().get(i).getTagName().equals("Defend")) this.getMenuTabs().get(i).click();

        }
        return new DefendPage(webDriver);

    }

    public ProfilesPage proceedToProfilesTab(){
        for (int i=0; i< this.getMenuTabs().size(); i++ ){
            if(this.getMenuTabs().get(i).getTagName().equals("Profiles")) this.getMenuTabs().get(i).click();

        }
        return new ProfilesPage(webDriver);

    }
}
