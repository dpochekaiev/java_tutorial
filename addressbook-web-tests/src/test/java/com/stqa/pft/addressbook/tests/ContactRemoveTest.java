package com.stqa.pft.addressbook.tests;

import com.stqa.pft.addressbook.model.AccountMap;
import org.testng.annotations.Test;

public class ContactRemoveTest extends TestBase {

    @Test
    public void testContactRemove() {
        System.out.println("================================================");
        System.out.println("Running testContactRemove");
        AccountMap dummyContact = new AccountMap(
                "Just",
                "A",
                "Dummy contact",
                "", "", "", "", "",
                null, null, null);

        app.getNavigationHelper().gotoHomePage();

        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(dummyContact, true);
        }

        app.getContactHelper().selectContact();
        app.getContactHelper().deleteSelectedContact();
        app.getNavigationHelper().gotoHomePage();
    }

}
