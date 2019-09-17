package com.stqa.pft.addressbook.tests;

import com.stqa.pft.addressbook.model.AccountMap;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactEmailTest extends TestBase {

    @BeforeMethod
    public void ensurePreConditions() {
        AccountMap dummyContact = new AccountMap().withFirstName("Just").withMiddleName("A").withSurname("Dummy Contact")
                .withEmailFirst("FIRSTemail@mail.dot.COM").withEmailSecond("second_email@dot.get").withEmailThird("e-Mail.3@ya.ru");
        app.goTo().homePage();
        if (app.contact().list().size() == 0) {
            app.contact().create(dummyContact, true);
        }
    }

    @Test
    public void testContactEmail() {
// preparation part
        System.out.println("================================================");
        System.out.println("Running testContactEmail");

// test part
        app.goTo().homePage();
        AccountMap contactForTest = app.contact().all().iterator().next();
        AccountMap contactInfoFromEditForm = app.contact().infoFromEditForm(contactForTest);

// outcoming part
        assertThat(contactForTest.getEmails(), equalTo(mergeEmails(contactInfoFromEditForm)));
        System.out.println("Test passed");
    }


    private String mergeEmails(AccountMap contact) {
        return Arrays.asList(contact.getEmailFirst(), contact.getEmailSecond(), contact.getEmailThird())
                .stream().filter((s) -> ! s.equals(""))
                .map(ContactEmailTest::cleanedEmails)
                .collect(Collectors.joining("\n"));
    }

    public static String cleanedEmails (String phoneNumber) {
        return phoneNumber.replaceAll("\\s", "");
    }

}
