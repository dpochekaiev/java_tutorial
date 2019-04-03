package com.stqa.pft.addressbook.tests;

import com.stqa.pft.addressbook.model.AccountMap;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ContactModificationTest extends TestBase {

    @Test
    public void testContactModification() {

        AccountMap editedContact = new AccountMap(
                "EditedName",
                "E",
                "EditedSurname",
                "EditedCompany",
                "EditedAddress",
                "0800000111000",
                "EdItEd@MaIl.DoT.cOm",
              "",//  "9",
              "",//  "April",
                "1988");

        app.getNavigationHelper().gotoHomePage();
        app.getContactHelper().EditContact();
        app.getContactHelper().fillContactForm(editedContact);
        app.getContactHelper().submitContactUpdate();
        app.getContactHelper().returnToMainPage();

        //TODO: :following rows are workaround for bug in the application: a record is deleted instead of updating
        app.getContactHelper().initContactCreation();
        app.getContactHelper().fillContactForm(editedContact);
        app.getContactHelper().submitContactCreation();
        app.getContactHelper().returnToMainPage();
    }
}
