package Utilities;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;
import org.openqa.selenium.WebElement;
import pages.MenuTabs;

import java.util.ArrayList;
import java.util.List;

public class GoToTabsMatcher extends TypeSafeMatcher<MenuTabs> {
    private final List<String> tabNames;

    public GoToTabsMatcher(List<String> tabNames) {
        this.tabNames = tabNames;
    }

    protected boolean matchesSafely(final MenuTabs menuTabs) {
        int tabsClickedSuccessfully = 0;
        List<WebElement> menuTabsList = menuTabs.getMenuTabsList();
        List<String> menuTabsListNames = new ArrayList<String>();


        for (WebElement tab: menuTabsList
                ) {
            menuTabsListNames.add(tab.getText());
                   }
        for (String tabName: tabNames
                ) {
            if (menuTabsListNames.indexOf(tabName) != -1) {
                if (menuTabs.clickTabWaitPageLoaded(menuTabsList.get(menuTabsListNames.indexOf(tabName)))) {
                  // if (menuTabsList.get(menuTabsListNames.indexOf(tabName)).isDisplayed())
                    //(menuTabsList.get(menuTabsListNames.indexOf(tabName)).getClass().toString() != "parent active-menu-item")&&
                    System.out.println((menuTabsList.get(menuTabsListNames.indexOf(tabName)).getClass().toString()));
                    System.out.println(tabName + " " + menuTabsListNames.indexOf(tabName) + " clicked");
                    tabsClickedSuccessfully++;
                }
            }
        }


        if(tabsClickedSuccessfully == tabNames.size()) return  true;
        else return false;
    }

    public void describeTo(Description description) {
        description.appendText("Tab are clickable");
    }

    public static GoToTabsMatcher canClickTabs(final List<String> tabNames){
        return new GoToTabsMatcher(tabNames);
    }
}
