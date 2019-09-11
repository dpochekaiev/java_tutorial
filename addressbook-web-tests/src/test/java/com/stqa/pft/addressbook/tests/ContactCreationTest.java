package com.stqa.pft.addressbook.tests;

        import com.stqa.pft.addressbook.model.AccountMap;
        import com.stqa.pft.addressbook.model.Accounts;
        import com.stqa.pft.addressbook.model.GroupMap;
        import org.testng.annotations.*;

        import static org.hamcrest.CoreMatchers.equalTo;
        import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTest extends TestBase {

    @BeforeMethod
    public void ensurePreConditions() {
        app.goTo().groupPage();
        if (app.group().all().size() == 0) {
            app.group().create(new GroupMap().withGroupName("test1").withGroupHeader("Some Dummy Group"));
        }
    }

    @Test
    public void testContactCreation() throws Exception {
// preparation part
        System.out.println("================================================");
        System.out.println("Running testContactCreation");
        AccountMap newContact = new AccountMap().withFirstName("Neko Name").withMiddleName("S")
                .withSurname("Family Name").withCompany("Some Company").withAddress(" \n   Some address \n \n with several rows")
                .withHomePhoneNumber("123456789").withMobilePhoneNumber("380666442211")
                .withWorkPhoneNumber("05726680254").withEmailFirst("email@mail.com")
                .withEmailSecond("Second_email@some.domain").withEmailThird("Email_No_3@mail.ru")
                .withDayOfBirth("13").withMonthOfBirth("January").withYearOfBirth("1988").withGroup("test1");
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
