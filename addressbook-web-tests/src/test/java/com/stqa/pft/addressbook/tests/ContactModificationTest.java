package com.stqa.pft.addressbook.tests;

import com.stqa.pft.addressbook.model.AccountMap;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
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

        app.goTo().homePage();
        if (app.contact().list().size() == 0) {
            app.contact().create(dummyContact, true);
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

        List<AccountMap> startingTestContactsList = app.contact().list();

// test part

        List<AccountMap> beforeTestContactsList = app.contact().list();
        app.contact().modify(editContactIndex, editedContact);

        //TODO: :following rows are workaround for bug in the application: a record is deleted instead of updating
        app.contact().initContactCreation();
        app.contact().fillContactForm(editedContact, true);
        app.contact().submitContactCreation();
        app.contact().returnToMainPage();

// outcoming part
        List<AccountMap> afterTestContactsList = app.contact().list();
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
        beforeTestContactsList = app.contact().sortAscending(beforeTestContactsList);
        afterTestContactsList = app.contact().sortAscending(afterTestContactsList);
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
