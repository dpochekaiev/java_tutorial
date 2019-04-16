package com.stqa.pft.addressbook.tests;

import com.stqa.pft.addressbook.model.AccountMap;
import org.testng.Assert;
import org.testng.annotations.Test;

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
        int startingTestContactCount = app.getContactHelper().getContactCount();
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(dummyContact, true);
        }

// test part
        int beforeTestContactsCount = app.getContactHelper().getContactCount();
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteSelectedContact();
        app.getNavigationHelper().gotoHomePage();

// outcoming part
        int afterTestContactsCount = app.getContactHelper().getContactCount();
        System.out.println("Initially contacts before test: " + startingTestContactCount);
        System.out.println("Contacts before test: " + beforeTestContactsCount);
        System.out.println("Contacts after test: " + afterTestContactsCount);
        Assert.assertEquals(afterTestContactsCount, beforeTestContactsCount - 1);
    }

}
