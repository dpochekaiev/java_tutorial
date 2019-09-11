package com.stqa.pft.addressbook.tests;

import com.stqa.pft.addressbook.model.AccountMap;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactViewTest extends TestBase  {

    @BeforeMethod
    public void ensurePreConditions() {
        AccountMap dummyContact = new AccountMap().withFirstName("Guy").withSurname("View Test")
                .withAddress("Street line \n County line \n \n 01234 ZIP code")
                .withEmailFirst("FIRSTemail@mail.dot.COM").withEmailSecond("second_email@dot.get")
                .withEmailThird("e-Mail.3@ya.ru").withMobilePhoneNumber("44-22-11")
                .withHomePhoneNumber("(0572) 65 79-03").withWorkPhoneNumber("+38(066) 123-45-67");
        app.goTo().homePage();
        app.contact().create(dummyContact, true);
    }

    @Test (enabled = false)
    public void testContactView() {

    }


}
