package com.stqa.pft.addressbook.tests;

import com.stqa.pft.addressbook.model.AccountMap;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAddressTest extends TestBase {

    @BeforeMethod
    public void ensurePreConditions() {
        AccountMap dummyContact = new AccountMap().withFirstName("Just").withMiddleName("A").withSurname("Dummy Contact")
                .withAddress("Street line \n County line \n \n 01234 ZIP code");
        app.goTo().homePage();
        if (app.contact().list().size() == 0) {
            app.contact().create(dummyContact, true);
        }
    }
    @Test
    public void testContactAddress() {
// preparation part
        System.out.println("================================================");
        System.out.println("Running testContactAddress");

// test part
        app.goTo().homePage();
        AccountMap contactForTest = app.contact().all().iterator().next();
        AccountMap contactInfoFromEditForm = app.contact().infoFromEditForm(contactForTest);

// outcoming part
        assertThat(cleanedAddress(contactForTest.getAddress()), equalTo(cleanedAddress(contactInfoFromEditForm.getAddress())));

        System.out.println("The column of Address from main window:");
        System.out.println(contactForTest.getAddress());
        System.out.println();
        System.out.println("The column of Address from edit form:");
        System.out.println(contactInfoFromEditForm.getAddress());
    }

    public static String cleanedAddress (String phoneNumber) {
        return phoneNumber.replaceAll("\\s", "");
    }

}
