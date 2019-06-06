package com.stqa.pft.addressbook.appmanager;

import com.stqa.pft.addressbook.model.AccountMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {

    private String editContactLinkSelector = "//tr/following::img[2]";

    public ContactHelper(WebDriver driver) {
        super(driver);
    }

    public void fillContactForm(AccountMap accountMap, boolean creation) {
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
//        if (isElementPresent(By.name("new_group"))) {
//            selectDropdownValue(By.name("new_group"), accountMap.getGroup());
//        }
        if (creation) {
            selectDropdownValue(By.name("new_group"), accountMap.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }

    public void submitContactCreation() {
        click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Notes:'])[1]/following::input[1]"));
     //   driver.findElement(By.id("content")).click();
    }

    public void initContactCreation() {
        click(By.linkText("add new"));
    }

    public void editContact() {
        click(By.xpath(editContactLinkSelector));
//        click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='dummy@mail.dot'])[1]/following::img[2]"));
    }

    public void editContactByIndex(int editContactIndex) {
        driver.findElements(By.xpath(editContactLinkSelector)).get(editContactIndex).click();
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

    public void selectContactByIndex(int selectContactIndex) {
        driver.findElements(By.name("selected[]")).get(selectContactIndex).click();
    }

    public void deleteSelectedContact() {
        click(By.xpath("//input[@type='button' and @value='Delete']"));
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public void createContact(AccountMap contact, boolean creation) {
        initContactCreation();
        fillContactForm(contact, creation);
        submitContactCreation();
        returnToMainPage();
    }

    public int getContactCount() {
        //return driver.findElements(By.name("selected[]")).size();
        return driver.findElements(By.xpath(editContactLinkSelector)).size();
    }

    public List<AccountMap> getContactList() {
        List<AccountMap> accounts = new ArrayList<AccountMap>();
        List<WebElement> elements = driver.findElements(By.xpath(editContactLinkSelector));
        List<WebElement> surnames = driver.findElements(By.xpath("//tr[@name='entry']/td[2]"));
        List<WebElement> names = driver.findElements(By.xpath("//tr[@name='entry']/td[3]"));
        List<WebElement> addresses = driver.findElements(By.xpath("//tr[@name='entry']/td[4]"));
        List<WebElement> emails = driver.findElements(By.xpath("//tr[@name='entry']/td[5]"));
        List<WebElement> phones = driver.findElements(By.xpath("//tr[@name='entry']/td[6]"));
        int i = 0;
        for (WebElement element : elements) {
            String surname = surnames.get(i).getText();
            String name = names.get(i).getText();
            String address = addresses.get(i).getText();
            String email = emails.get(i).getText();
            String phone = phones.get(i).getText();
            i++;
            String checkBoxForContactByIndexXPath = "(//td[@class='center']/input)[" + i + "]";
            int contactID = Integer.parseInt(element.findElement(By.xpath(checkBoxForContactByIndexXPath)).getAttribute("value"));
            AccountMap account = new AccountMap(contactID, name, null, surname, null, address,phone, email,
                    null, null, null, null);
            accounts.add(account);
        }
        return accounts;
    }
}
