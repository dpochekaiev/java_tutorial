package com.stqa.pft.addressbook.tests;

import com.stqa.pft.addressbook.model.AccountMap;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class ContactRemoveTest extends TestBase {

    @BeforeMethod
    public void ensurePreConditions() {
        AccountMap dummyContact = new AccountMap().withFirstName("Just").withMiddleName("A").withSurname("Dummy Contact");
        app.goTo().homePage();
        if (app.contact().list().size() == 0) {
            app.contact().create(dummyContact, true);
        }
    }

    @Test
    public void testContactRemove() {
// preparation part
        System.out.println("================================================");
        System.out.println("Running testContactRemove");
        int contactToRemoveIndex = 0;
        List<AccountMap> beforeTestContactsList = app.contact().list();

// test part
        app.contact().remove(contactToRemoveIndex);

// outcoming part
        List<AccountMap> afterTestContactsList = app.contact().list();
        System.out.println("Contacts before test: " + beforeTestContactsList.size());
        System.out.println("Contacts after test: " + afterTestContactsList.size());
        Assert.assertEquals(afterTestContactsList.size(), beforeTestContactsList.size() - 1);

        beforeTestContactsList.remove(contactToRemoveIndex);
        Comparator<? super AccountMap> byContactID = (g1, g2) -> Integer.compare(g1.getContactID(), g2.getContactID());
        beforeTestContactsList.sort(byContactID);
        afterTestContactsList.sort(byContactID);
        Assert.assertEquals(beforeTestContactsList, afterTestContactsList);

        //TODO: :remove redundant lines
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
    }


}
