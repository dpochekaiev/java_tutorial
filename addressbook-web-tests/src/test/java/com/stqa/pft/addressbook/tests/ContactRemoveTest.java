package com.stqa.pft.addressbook.tests;

import com.stqa.pft.addressbook.model.AccountMap;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ContactRemoveTest extends TestBase {

    @Test
    public void testContactRemove() {
// preparation part
        System.out.println("================================================");
        System.out.println("Running testContactRemove");
        AccountMap dummyContact = new AccountMap(
                "Just",
                "A",
                "Dummy contact",
                "", "", "", "", "",
                null, null, null);

        app.getNavigationHelper().gotoHomePage();
        List<AccountMap> startingTestContactsList = app.getContactHelper().getContactList();
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(dummyContact, true);
        }

// test part
        List<AccountMap> beforeTestContactsList = app.getContactHelper().getContactList();
        app.getContactHelper().selectContactByIndex(0);
        app.getContactHelper().deleteSelectedContact();
        app.getNavigationHelper().gotoHomePage();

// outcoming part
        List<AccountMap> afterTestContactsList = app.getContactHelper().getContactList();
        System.out.println("Initially contacts before test: " + startingTestContactsList.size());
        System.out.println("Contacts before test: " + beforeTestContactsList.size());
        System.out.println("Contacts after test: " + afterTestContactsList.size());
        Assert.assertEquals(afterTestContactsList.size(), beforeTestContactsList.size() - 1);
    }

}
