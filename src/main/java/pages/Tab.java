package pages;

import exceptions.TabNotFoundException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Tab {
    WebDriver webDriver;
  //  WebElement tab;
    String tabLocator;

    public Tab(String tabLocator, WebDriver webDriver) {
        this.webDriver = webDriver;
        this.tabLocator = tabLocator;
      //  tab = webDriver.findElement(By.id(tabLocator)); // DONE remove tab at all, use locator in click()
    }

    //isDisplayed - is the tab displayed in Menu Items? INITIALIZE  WebElement tab

    public boolean isDisplayed() {//DONE findElements by id hometab if empty - not displayed; REMOVE parameter locator, use tabLocator
        if(webDriver.findElements(By.id(tabLocator)).size() == 0) return false;
        else return true;
        /*tab = webDriver.findElement(By.id(tabLocator)).isDisplayed();
        return (tab != null); */
    }

    public boolean click() {//DONE return boolean 1 if clicked 0 if not displayed
        if (this.isDisplayed()) {
            webDriver.findElement(By.id(tabLocator)).click();//use locator instead
            return true;
        } else return false;
        //throw new TabNotFoundException("Tha tab " + tabLocator + " is not displayed");
    }
}
