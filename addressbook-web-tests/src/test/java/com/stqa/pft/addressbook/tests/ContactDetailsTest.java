package com.stqa.pft.addressbook.tests;

import com.stqa.pft.addressbook.model.AccountMap;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDetailsTest extends TestBase  {

    @BeforeMethod
    public void ensurePreConditions() {
        AccountMap dummyContact = new AccountMap().withFirstName("Test Guy").withSurname("Details View")
                .withAddress("Street line \n County line \n \n 01234 ZIP code")
                .withEmailFirst("FIRSTemail@mail.dot.COM").withEmailSecond("second_email@dot.get")
                .withEmailThird("e-Mail.3@ya.ru").withMobilePhoneNumber("44-22-11")
                .withHomePhoneNumber("(0572) 65 79-03").withWorkPhoneNumber("+38(066) 123-45-67");
        app.goTo().homePage();
        app.contact().create(dummyContact, true);
    }

    @AfterMethod
    public void clearAfterTest() {
        app.goTo().homePage();
        AccountMap contactForClear = app.contact().getLastCreatedAccount();
        app.contact().remove(contactForClear);
    }

    @Test //(enabled = false)
    public void testContactDetails() {
// preparation part
        System.out.println("================================================");
        System.out.println("Running testContactDetails");

// test part
        app.goTo().homePage();
        AccountMap contactForTest = app.contact().getLastCreatedAccount();
        AccountMap contactInfoFromEditForm = app.contact().infoFromEditForm(contactForTest);
        contactInfoFromEditForm.withDetials(
                contactInfoFromEditForm.getFirst() +
                        contactInfoFromEditForm.getSurname() +
                        contactInfoFromEditForm.getAddress() +
                "H: " + contactInfoFromEditForm.getHomePhoneNumber() +
                "M: " + contactInfoFromEditForm.getMobilePhoneNumber() +
                "W: " + contactInfoFromEditForm.getWorkPhoneNumber() +
                        contactInfoFromEditForm.getEmailFirst() +
                        contactInfoFromEditForm.getEmailSecond() +
                        contactInfoFromEditForm.getEmailThird());
        AccountMap contactInfoFromDetailsForm= app.contact().infoFromDetailsForm(contactForTest);
// outcoming part
        assertThat(cleanedContactDetails(contactInfoFromEditForm.getDetails()),
                equalTo(cleanedContactDetails(contactInfoFromDetailsForm.getDetails())));

        System.out.println("Details from main window:");
        System.out.println(contactInfoFromEditForm.getDetails());
        System.out.println();
        System.out.println("Details from edit form:");
        System.out.println(contactInfoFromDetailsForm.getDetails());


        System.out.println(contactForTest);
    }


    public static String cleanedContactDetails (String details) {
        return details.replaceAll("\\s", "");
    }

}
