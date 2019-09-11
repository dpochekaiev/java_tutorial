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

        System.out.println("Emails from main window;     Emails from edit form");
        System.out.print("mailFirst:      ");
        System.out.println(contactForTest.getEmailFirst() + "   " + contactInfoFromEditForm.getEmailFirst());
        System.out.print("EmailSecond:    ");
        System.out.println(contactForTest.getEmailSecond() + "   " + contactInfoFromEditForm.getEmailSecond());
        System.out.print("EmailThird:      ");
        System.out.println(contactForTest.getEmailThird() + "   " + contactInfoFromEditForm.getEmailThird());
        System.out.println();
        System.out.println("The column of Emails from main window:");
        System.out.println(contactForTest.getEmails());
        System.out.println();
        System.out.println("The column of Emails from edit form:");
        System.out.println(contactInfoFromEditForm.getEmails());
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
