package com.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase{

    public NavigationHelper(WebDriver driver) {
        super(driver);
    }

    public void gotoGroupPage() {
        if (
//                isElementPresent(By.tagName("h1"))
//                && driver.findElement(By.tagName("h1")).getText().equals("Groups")
//                && isElementPresent(By.xpath("//div[@id='content' and h1='Groups']"))
                isElementPresent(By.xpath("//div[h1='Groups']"))
                && isElementPresent(By.xpath("//input[@name='new' and @value='New group']"))) {
            return;
        }
        click(By.linkText("groups"));
    }


    public void gotoHomePage() {
        if (isElementPresent(By.id("maintable"))) {
//                isElementPresent(By.xpath("//table[@id='maintable']"))) {
            return;
        }
        click(By.linkText("home"));
    }
}
