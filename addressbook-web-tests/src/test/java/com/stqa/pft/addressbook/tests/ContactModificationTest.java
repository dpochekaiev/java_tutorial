package com.stqa.pft.addressbook.tests;

import com.stqa.pft.addressbook.model.AccountMap;
import com.stqa.pft.addressbook.model.Accounts;
import com.stqa.pft.addressbook.model.GroupMap;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTest extends TestBase {

    @BeforeMethod
    public void ensurePreConditions() {
        app.goTo().groupPage();
        if (app.group().all().size() == 0) {
            app.group().create(new GroupMap().withGroupName("test1").withGroupHeader("Some Dummy Group"));
        }
        AccountMap dummyContact = new AccountMap().withFirstName("Just").withMiddleName("A").withSurname("Dummy Contact");
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
        Accounts beforeTestContactsList = app.contact().all();
        AccountMap contactToEdit = beforeTestContactsList.iterator().next();
        AccountMap editedContact = new AccountMap().withContactID(contactToEdit.getContactID()).withFirstName("EditedName")
                .withMiddleName("E").withSurname("EditedSurname").withCompany("EditedCompany")
                .withAddress("EditedAddress").withHomePhoneNumber("0800000111000").withMobilePhoneNumber("222")
                .withWorkPhoneNumber("333").withEmailFirst("EdItEd@MaIl.DoT.cOm").withMonthOfBirth("April")
                // Clearing the value of Day of Birth field
                .withDayOfBirth("-")
                .withYearOfBirth("2000").withGroup("test1")
                .withPhoto(new File("src/test/resources/enchantress_logo.png"));


// test part
        app.contact().modify(editedContact);

        //TODO: :following rows are workaround for bug in the application: a record is deleted instead of updating
        app.contact().initContactCreation();
        app.contact().fillContactForm(editedContact, true);
        app.contact().submitContactCreation();
        app.contact().returnToMainPage();
        //TODO: The end of workaround

// outcoming part
        assertThat(app.contact().count(), equalTo(beforeTestContactsList.size()));
        Accounts afterTestContactsList = app.contact().all();
        System.out.println("Contacts before test: " + beforeTestContactsList.size());
        System.out.println("Contacts after test: " + afterTestContactsList.size());
        assertThat(afterTestContactsList, equalTo((beforeTestContactsList).without(contactToEdit).withAdded(editedContact
                .withContactID(afterTestContactsList.stream().mapToInt((c) -> c.getContactID()).max().getAsInt()))));
        System.out.println("Test passed");
    }

}
