package com.stqa.pft.addressbook.tests;

import com.stqa.pft.addressbook.model.AccountMap;
import com.stqa.pft.addressbook.model.Accounts;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

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
        int amountOfAccounts = app.contact().list().size();
        for (int i = 1; i<= amountOfAccounts; i++) {
            System.out.println("Iteration No"+i);
            Accounts beforeTestContactsList = app.contact().all();
            AccountMap contactToDelete = beforeTestContactsList.iterator().next();
// test part
            app.contact().remove(contactToDelete);

// outcoming part
            assertThat(app.contact().count(), equalTo(beforeTestContactsList.size() - 1));
            Accounts afterTestContactsList = app.contact().all();
            System.out.println("Contacts before test: " + beforeTestContactsList.size());
            System.out.println("Contacts after test: " + afterTestContactsList.size());
            assertThat(afterTestContactsList, equalTo((beforeTestContactsList).without(contactToDelete)));
            System.out.println("Test passed");
        }
    }


}
