package com.stqa.pft.addressbook.tests;

import com.stqa.pft.addressbook.model.AccountMap;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class ContactPhoneTest extends TestBase {

    @BeforeMethod
    public void ensurePreConditions() {
        AccountMap dummyContact = new AccountMap().withFirstName("Just").withMiddleName("A").withSurname("Dummy Contact")
                .withWorkPhoneNumber("44-22-11").withHomePhoneNumber("(0572) 65 79-03").withMobilePhoneNumber("+38(066) 123-45-67");
        app.goTo().homePage();
        if (app.contact().list().size() == 0) {
            app.contact().create(dummyContact, true);
        }
    }

    @Test
    public void testContactPhones() {
// preparation part
        System.out.println("================================================");
        System.out.println("Running testContactPhones");

// test part
        app.goTo().homePage();
        AccountMap contactForTest = app.contact().all().iterator().next();
        AccountMap contactInfoFromEditForm = app.contact().infoFromEditForm(contactForTest);

// outcoming part
        assertThat(contactForTest.getPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
        System.out.println("Test passed");
    }

    private String mergePhones(AccountMap contact) {
        return Arrays.asList(contact.getHomePhoneNumber(), contact.getMobilePhoneNumber(), contact.getWorkPhoneNumber())
                .stream().filter((s) -> ! s.equals(""))
                .map(ContactPhoneTest::cleanedPhones)
                .collect(Collectors.joining("\n"));
    }

    public static String cleanedPhones (String phoneNumber) {
        return phoneNumber.replaceAll("[-()]", "").replaceAll("\\s", "");
    }

}
