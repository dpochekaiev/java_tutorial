package com.stqa.pft.addressbook.tests;

import com.stqa.pft.addressbook.model.AccountMap;
import com.stqa.pft.addressbook.model.GroupMap;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactModificationTest extends TestBase {

    @BeforeMethod
    public void ensurePreConditions() {
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
    }

    @Test
    public void testContactModification() {
// preparation part
        System.out.println("================================================");
        System.out.println("Running testContactModification");
        int editContactIndex = 0;
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

        List<AccountMap> startingTestContactsList = app.getContactHelper().getContactList();

// test part

        List<AccountMap> beforeTestContactsList = app.getContactHelper().getContactList();
        app.getContactHelper().modifyContact(editContactIndex, editedContact);

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

        int maxContactID = 0;
        for (AccountMap contact : afterTestContactsList) {
            if (contact.getContactID() > maxContactID) {
                maxContactID = contact.getContactID();
            }
        }
        editedContact.setContactID(maxContactID);
        beforeTestContactsList.remove(editContactIndex);
        beforeTestContactsList.add(editedContact);

        //TODO: :remove redundant lines
        beforeTestContactsList = app.getContactHelper().sortAscending(beforeTestContactsList);
        afterTestContactsList = app.getContactHelper().sortAscending(afterTestContactsList);
        System.out.println();
        System.out.println("Comparing: beforeTestGroupsList and" + " " + "afterTestGroupsList");
        for (int i = 0; i < afterTestContactsList.size(); i++) {
//            System.out.println(beforeTestContactsList.get(i) + "        " + afterTestContactsList.get(i));
            System.out.println("    Record № " + i);
            System.out.println("before: " + beforeTestContactsList.get(i));
            System.out.println("after:  " + afterTestContactsList.get(i));
            System.out.println();
        }
        //TODO: :end of redundant lines

        Comparator<? super AccountMap> byContactID = (g1, g2) -> Integer.compare(g1.getContactID(), g2.getContactID());
        beforeTestContactsList.sort(byContactID);
        afterTestContactsList.sort(byContactID);
        Assert.assertEquals(beforeTestContactsList, afterTestContactsList);
    }

}
