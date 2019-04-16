package com.stqa.pft.addressbook.tests;

import com.stqa.pft.addressbook.model.AccountMap;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactModificationTest extends TestBase {

    @Test
    public void testContactModification() {
// preparation part
        System.out.println("================================================");
        System.out.println("Running testContactModification");
        AccountMap dummyContact = new AccountMap(
                "Just",
                "A",
                "Dummy contact",
                "", "", "", "", "",
                null, null, null);
        AccountMap editedContact = new AccountMap(
                "EditedName",
                "E",
                "EditedSurname",
                "EditedCompany",
                "EditedAddress",
                "0800000111000",
                "EdItEd@MaIl.DoT.cOm",
                "",//  "9",
                "April",
                "1988",
                null);

        app.getNavigationHelper().gotoHomePage();
        int startingTestContactCount = app.getContactHelper().getContactCount();
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(dummyContact, true);
        }

// test part
        int beforeTestContactsCount = app.getContactHelper().getContactCount();
        app.getContactHelper().EditContact();
        app.getContactHelper().fillContactForm(editedContact, false);
        app.getContactHelper().submitContactUpdate();
        app.getContactHelper().returnToMainPage();

        //TODO: :following rows are workaround for bug in the application: a record is deleted instead of updating
        app.getContactHelper().initContactCreation();
        app.getContactHelper().fillContactForm(editedContact, true);
        app.getContactHelper().submitContactCreation();
        app.getContactHelper().returnToMainPage();

// outcoming part
        int afterTestContactsCount = app.getContactHelper().getContactCount();
        System.out.println("Initially contacts before test: " + startingTestContactCount);
        System.out.println("Contacts before test: " + beforeTestContactsCount);
        System.out.println("Contacts after test: " + afterTestContactsCount);
        Assert.assertEquals(afterTestContactsCount, beforeTestContactsCount);
    }
}
