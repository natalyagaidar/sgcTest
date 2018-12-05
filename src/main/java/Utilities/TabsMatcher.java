package Utilities;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;
import org.openqa.selenium.WebElement;
import pages.MenuTabs;

import java.util.ArrayList;
import java.util.List;

public class TabsMatcher extends TypeSafeMatcher<MenuTabs> {

    private final List<String> tabNames;

    public TabsMatcher(List<String> tabNames) {
        this.tabNames = tabNames;
    }

    protected boolean matchesSafely(final MenuTabs menuTabs) {
        int tabNamesMatches = 0;
        List<WebElement> menuTabsList = menuTabs.getMenuTabsList();
        List<String> menuTabsListNames = new ArrayList<String>();

        for (WebElement tab: menuTabsList
                ) {
            menuTabsListNames.add(tab.getText());
        }
        for (String tabName: tabNames
             ) {
            if (menuTabsListNames.contains(tabName))
            {
                tabNamesMatches++;
            }

        }
        if(tabNamesMatches == tabNames.size()) return  true;
        else return false;
    }

    public void describeTo(final Description description) {
 description.appendText("Tab names match");
    }

    public static TabsMatcher matchTabs(final List<String> tabNames){
        return new TabsMatcher(tabNames);
    }


}
