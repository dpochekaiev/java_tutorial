package com.stqa.pft.addressbook.appmanager;

import com.stqa.pft.addressbook.model.AccountMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver driver) {
        super(driver);
    }

    public void fillAccountForm(AccountMap accountMap) {
        type(By.name("firstname"), accountMap.getFirst());
        type(By.name("middlename"), accountMap.getMiddleName());
        type(By.name("lastname"), accountMap.getSurname());
        type(By.name("company"), accountMap.getCompany());
        type(By.name("address"), accountMap.getAddress());

        click(By.name("theform"));

        type(By.name("home"), accountMap.getHomePhoneNumber());
        type(By.name("email"), accountMap.getEmailFirst());


        selectDropdownValue(By.name("bday"), accountMap.getDayOfBirth());
//        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Birthday:'])[1]/following::option[3]")).click();

        selectDropdownValue(By.name("bmonth"), accountMap.getMonthOfBirth());
//        driver.findElement(By.name("bmonth")).click();
//        new Select(driver.findElement(By.name("bmonth"))).selectByVisibleText(accountMap.getMonthOfBirth());

//        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Birthday:'])[1]/following::option[35]")).click();

        type(By.name("byear"), accountMap.getYearOfBirth());

        click(By.name("theform"));

    }

    public void submitAccountCreation() {
        click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Notes:'])[1]/following::input[1]"));
     //   driver.findElement(By.id("content")).click();
    }

    public void initAccountCreation() {
        click(By.linkText("add new"));
    }
}
