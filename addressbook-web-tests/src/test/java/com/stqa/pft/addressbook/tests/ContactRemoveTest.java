package com.stqa.pft.addressbook.tests;

import com.stqa.pft.addressbook.model.AccountMap;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

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
        Set<AccountMap> beforeTestContactsList = app.contact().all();
        AccountMap contactToDelete = beforeTestContactsList.iterator().next();
// test part
        app.contact().remove(contactToDelete);

// outcoming part
        Set<AccountMap> afterTestContactsList = app.contact().all();
        System.out.println("Contacts before test: " + beforeTestContactsList.size());
        System.out.println("Contacts after test: " + afterTestContactsList.size());
        Assert.assertEquals(afterTestContactsList.size(), beforeTestContactsList.size() - 1);

        beforeTestContactsList.remove(contactToDelete);
        Assert.assertEquals(beforeTestContactsList, afterTestContactsList);

    }


}
