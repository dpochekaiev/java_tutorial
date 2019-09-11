package com.stqa.pft.addressbook.appmanager;

import com.stqa.pft.addressbook.model.AccountMap;
import com.stqa.pft.addressbook.model.Accounts;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;
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
        type(By.name("work"), accountMap.getWorkPhoneNumber());
        type(By.name("mobile"), accountMap.getMobilePhoneNumber());
        type(By.name("email"), accountMap.getEmailFirst());
        type(By.name("email2"), accountMap.getEmailSecond());
        type(By.name("email3"), accountMap.getEmailThird());
        selectDropdownValue(By.name("bday"), accountMap.getDayOfBirth());  //        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Birthday:'])[1]/following::option[3]")).click();
        selectDropdownValue(By.name("bmonth"), accountMap.getMonthOfBirth());  //        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Birthday:'])[1]/following::option[35]")).click();
        type(By.name("byear"), accountMap.getYearOfBirth());
        if (isElementPresent(By.name("new_group"))) {
            selectDropdownValue(By.name("new_group"), accountMap.getGroup());
        }
        if (!creation) {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
//            selectDropdownValue(By.name("new_group"), accountMap.getGroup());
//        } else {
//            Assert.assertFalse(isElementPresent(By.name("new_group")));
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

    /**
     * Using parameres in the string
     * @param editContactID
     */

    public void initContactModificationByID(int editContactID) {
//        driver.findElement(By.cssSelector("a[href='edit.php?id=" + editContactID + "'")).click();
        driver.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s'", editContactID))).click();
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
        contactCache = null;
        returnToMainPage();
    }

    public int count() {
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
                    .withAddress(address));
//                    .withHomePhoneNumber(phone).withEmailFirst(email));
        }
        return accounts;
    }

    private Accounts contactCache = null;

    /**
     * Returns a set of contacts
     */
    public Accounts all() {
        if (contactCache != null) {
            return new Accounts(contactCache);
        }
        contactCache = new Accounts();
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
            String allEmails = emails.get(i).getText();
            String allPhones = phones.get(i).getText();
            i++;
            String checkBoxForContactByIndexXPath = "(//td[@class='center']/input)[" + i + "]";
            int contactID = Integer.parseInt(element.findElement(By.xpath(checkBoxForContactByIndexXPath))
                    .getAttribute("value"));
            contactCache.add(new AccountMap().withContactID(contactID).withFirstName(name).withSurname(surname)
                    .withAddress(address).withPhones(allPhones).withEmails(allEmails));
        }
        return new Accounts(contactCache);
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
        initContactModificationByID(editedContact.getContactID());
        fillContactForm(editedContact, false);
        submitContactUpdate();
        contactCache = null;
        returnToMainPage();
    }

    /**
     * Removes contact by index
     * @param contactToRemoveIndex
     */
    public void remove(int contactToRemoveIndex) {
       selectContactByIndex(contactToRemoveIndex);
        deleteSelectedContact();
        contactCache = null;
        returnToHomePage();

    }

    public void remove(AccountMap contactToDelete) {
        selectContactByID(contactToDelete.getContactID());
        deleteSelectedContact();
        contactCache = null;
        returnToHomePage();
    }

    public AccountMap infoFromEditForm(AccountMap contact) {
        //TODO: text for method is from lesson 56, time: 03:00
        initContactModificationByID(contact.getContactID());
        String firstName = driver.findElement(By.xpath("//input[@name='firstname']")).getAttribute("value");
        String middleName = driver.findElement(By.xpath("//input[@name='middlename']")).getAttribute("value");
        String surname = driver.findElement(By.xpath("//input[@name='lastname']")).getAttribute("value");
        String company = driver.findElement(By.xpath("//input[@name='company']")).getAttribute("value");
        String address = driver.findElement(By.xpath("//textarea[@name='address']")).getText();
        String homePhone = driver.findElement(By.xpath("//input[@name='home']")).getAttribute("value");
        String mobilePhone = driver.findElement(By.xpath("//input[@name='mobile']")).getAttribute("value");
        String workPhone = driver.findElement(By.xpath("//input[@name='work']")).getAttribute("value");
        String emailFirst = driver.findElement(By.xpath("//input[@name='email']")).getAttribute("value");
        String emailSecond = driver.findElement(By.xpath("//input[@name='email2']")).getAttribute("value");
        String emailThird = driver.findElement(By.xpath("//input[@name='email3']")).getAttribute("value");
        String dayOfBirthday = driver.findElement(By.xpath("//select[@name='bday']/option[@selected='selected']")).getText().replaceAll("-", "");
        String monthOfBirthday = driver.findElement(By.xpath("//select[@name='bmonth']/option[@selected='selected']")).getText().replaceAll("-", "");
        String yearOfBithday = driver.findElement(By.xpath("//input[@name='byear']")).getAttribute("value");
        driver.navigate().back();
        return new AccountMap().withFirstName(firstName).withMiddleName(middleName).withSurname(surname)
                .withCompany(company).withAddress(address).withHomePhoneNumber(homePhone)
                .withMobilePhoneNumber(mobilePhone).withWorkPhoneNumber(workPhone)
                .withEmailFirst(emailFirst).withEmailSecond(emailSecond).withEmailThird(emailThird)
                .withDayOfBirth(dayOfBirthday).withMonthOfBirth(monthOfBirthday).withYearOfBirth(yearOfBithday);

    }
}
