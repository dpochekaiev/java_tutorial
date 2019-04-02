package com.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase{

    public SessionHelper(WebDriver driver) {
        super(driver);
    }

    public void login(String userName, String userPassword) {
        type(By.name("user"), userName);
        type(By.name("pass"), userPassword);
//        click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Password:'])[1]/following::input[2]"));
        click(By.xpath(".//input[@type='submit']"));
    }

}
