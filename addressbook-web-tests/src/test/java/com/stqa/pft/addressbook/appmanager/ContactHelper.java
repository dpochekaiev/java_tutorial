package com.stqa.pft.addressbook.appmanager;

import com.stqa.pft.addressbook.model.AccountMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public void editContactByID(int editContactID) {
        driver.findElement(By.cssSelector("a[href='edit.php?id=" + editContactID + "'")).click();
    }

    public void submitContactUpdate() {
        click(By.name("update"));
    }

    public void returnToMainPage() {
        click(By.linkText("home page"));
    }

    public void returnToHomePage() {
        if (isElementPresent(By.id("maintable"))) {
            return;
        }
        click(By.linkText("home"));
    }

    public void selectContact() {
        click(By.name("selected[]"));
    }

    public void selectContactByID(int accountID) {
        click(By.cssSelector("input[value='" + accountID + "']"));
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

    /**
     * Creates a new contact
     * @param contact
     * @param creation
     */
    public void create(AccountMap contact, boolean creation) {
        initContactCreation();
        fillContactForm(contact, creation);
        submitContactCreation();
        returnToMainPage();
    }

    public int getContactCount() {
        //return driver.findElements(By.name("selected[]")).size();
        return driver.findElements(By.xpath(editContactLinkSelector)).size();
    }

    /**
     * Returns a list of contacts
     */
    public List<AccountMap> list() {
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
            accounts.add(new AccountMap().withContactID(contactID).withFirstName(name).withSurname(surname)
                    .withAddress(address).withHomePhoneNumber(phone).withEmailFirst(email));
        }
        return accounts;
    }

    /**
     * Returns a set of contacts
     */
    public Set<AccountMap> all() {
        Set<AccountMap> accounts = new HashSet<AccountMap>();
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
            accounts.add(new AccountMap().withContactID(contactID).withFirstName(name).withSurname(surname)
                    .withAddress(address).withHomePhoneNumber(phone).withEmailFirst(email));
        }
        return accounts;
    }

    public List<AccountMap> sortAscending (List<AccountMap> contactList) {
        if (contactList.size() < 2) {
            return contactList;
        }
        List<AccountMap> temporaryContactList = new ArrayList<AccountMap>();
        for (int j = contactList.size(); j > 0; j--) {

            int minAccountIdIndex = 0;
            int accountListLength = contactList.size();
            for (int i = 0; i < accountListLength; i++) {
                if (contactList.get(minAccountIdIndex).getContactID() > contactList.get(i).getContactID()) {
                    minAccountIdIndex = i;
                }
            }
            temporaryContactList.add(contactList.get(minAccountIdIndex));
            contactList.remove(minAccountIdIndex);
        }
        for (int i = 0; i < temporaryContactList.size(); i++) {
            contactList.add(temporaryContactList.get(i));
        }
        return contactList;

    }

    /**
     * Modifies a contact by index

     * @param editedContact
     */
    public void modify(AccountMap editedContact) {
        editContactByID(editedContact.getContactID());
        fillContactForm(editedContact, false);
        submitContactUpdate();
        returnToMainPage();
    }

    /**
     * Removes contact by index
     * @param contactToRemoveIndex
     */
    public void remove(int contactToRemoveIndex) {
       selectContactByIndex(contactToRemoveIndex);
        deleteSelectedContact();
        returnToHomePage();

    }

    public void remove(AccountMap contactToDelete) {
        selectContactByID(contactToDelete.getContactID());
        deleteSelectedContact();
        returnToHomePage();
    }
}
