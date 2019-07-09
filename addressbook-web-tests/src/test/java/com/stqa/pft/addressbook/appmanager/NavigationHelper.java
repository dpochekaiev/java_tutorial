package com.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase{

    public NavigationHelper(WebDriver driver) {
        super(driver);
    }

    public void groupPage() {
        if (isElementPresent(By.xpath("//div[h1='Groups']"))
                && isElementPresent(By.xpath("//input[@name='new' and @value='New group']"))) {
            return;
        }
        click(By.linkText("groups"));
    }


    public void homePage() {
        if (isElementPresent(By.id("maintable"))) {
            return;
        }
        click(By.linkText("home"));
    }
}
