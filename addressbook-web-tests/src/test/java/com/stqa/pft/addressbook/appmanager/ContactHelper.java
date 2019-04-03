package com.stqa.pft.addressbook.appmanager;

import com.stqa.pft.addressbook.model.AccountMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver driver) {
        super(driver);
    }

    public void fillContactForm(AccountMap accountMap) {
        type(By.name("firstname"), accountMap.getFirst());
        type(By.name("middlename"), accountMap.getMiddleName());
        type(By.name("lastname"), accountMap.getSurname());
        type(By.name("company"), accountMap.getCompany());
        type(By.name("address"), accountMap.getAddress());
        type(By.name("home"), accountMap.getHomePhoneNumber());
        type(By.name("email"), accountMap.getEmailFirst());
        selectDropdownValue(By.name("bday"), accountMap.getDayOfBirth());  //        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Birthday:'])[1]/following::option[3]")).click();
        selectDropdownValue(By.name("bmonth"), accountMap.getMonthOfBirth());  //        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Birthday:'])[1]/following::option[35]")).click();
        type(By.name("byear"), accountMap.getYearOfBirth());
    }

    public void submitContactCreation() {
        click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Notes:'])[1]/following::input[1]"));
     //   driver.findElement(By.id("content")).click();
    }

    public void initContactCreation() {
        click(By.linkText("add new"));
    }

    public void EditContact() {
        click(By.xpath("(//tr)[1]/following::img[2]"));
//        click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='dummy@mail.dot'])[1]/following::img[2]"));
    }

    public void submitContactUpdate() {
        click(By.name("update"));
    }

    public void returnToMainPage() {
        click(By.linkText("home page"));
    }

    public void selectContact() {
        click(By.name("selected[]"));
    }

    public void deleteSelectedContact() {
        click(By.xpath("//input[@type='button' and @value='Delete']"));
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

}
