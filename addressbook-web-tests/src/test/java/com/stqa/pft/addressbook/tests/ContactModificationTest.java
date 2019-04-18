package com.stqa.pft.addressbook.tests;

import com.stqa.pft.addressbook.model.AccountMap;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

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
        List<AccountMap> startingTestContactsList = app.getContactHelper().getContactList();
//        int startingTestContactCount = app.getContactHelper().getContactCount();
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(dummyContact, true);
        }

// test part
        List<AccountMap> beforeTestContactsList = app.getContactHelper().getContactList();
        app.getContactHelper().editContactByIndex(1);
        app.getContactHelper().fillContactForm(editedContact, false);
        app.getContactHelper().submitContactUpdate();
        app.getContactHelper().returnToMainPage();

        //TODO: :following rows are workaround for bug in the application: a record is deleted instead of updating
        app.getContactHelper().initContactCreation();
        app.getContactHelper().fillContactForm(editedContact, true);
        app.getContactHelper().submitContactCreation();
        app.getContactHelper().returnToMainPage();

// outcoming part
        List<AccountMap> afterTestContactsList = app.getContactHelper().getContactList();
        System.out.println("Initially contacts before test: " + startingTestContactsList.size());
        System.out.println("Contacts before test: " + beforeTestContactsList.size());
        System.out.println("Contacts after test: " + afterTestContactsList.size());
        Assert.assertEquals(afterTestContactsList.size(), beforeTestContactsList.size());
    }
}
