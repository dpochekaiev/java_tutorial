package com.stqa.pft.addressbook.tests;

        import com.stqa.pft.addressbook.model.AccountMap;
        import com.stqa.pft.addressbook.model.Accounts;
        import org.testng.annotations.*;

        import static org.hamcrest.CoreMatchers.equalTo;
        import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTest extends TestBase {

    @Test
    public void testContactCreation() throws Exception {
// preparation part
        System.out.println("================================================");
        System.out.println("Running testContactCreation");
        AccountMap newContact = new AccountMap().withFirstName("Neko Name").withMiddleName("S")
                .withSurname("Family Name").withCompany("Some Company").withAddress("Some address")
                .withHomePhoneNumber("123456789").withEmailFirst("email.mail.com").withDayOfBirth("13")
                .withMonthOfBirth("January").withYearOfBirth("1988").withGroup("test1");
// test part
        app.goTo().homePage();
        Accounts beforeTestContactsList = app.contact().all();
        app.contact().create(newContact, true);

// outcoming part
        assertThat(app.contact().count(), equalTo(beforeTestContactsList.size() + 1));
        Accounts afterTestContactsList = app.contact().all();
        System.out.println("Contacts before test: " + beforeTestContactsList.size());
        System.out.println("Contacts after test: " + afterTestContactsList.size());
        assertThat(afterTestContactsList, equalTo(beforeTestContactsList.withAdded(newContact.
                withContactID(afterTestContactsList.stream().mapToInt((c) -> c.getContactID()).max().getAsInt()))));



    }

}
