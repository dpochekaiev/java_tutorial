package com.stqa.pft.addressbook.tests;

        import com.stqa.pft.addressbook.model.AccountMap;
        import org.testng.Assert;
        import org.testng.annotations.*;

        import java.util.Comparator;
        import java.util.List;
        import java.util.Set;

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
        Set<AccountMap> beforeTestContactsList = app.contact().all();
        app.contact().create(newContact, true);

// outcoming part
        Set<AccountMap> afterTestContactsList = app.contact().all();
        System.out.println("Contacts before test: " + beforeTestContactsList.size());
        System.out.println("Contacts after test: " + afterTestContactsList.size());
        Assert.assertEquals(afterTestContactsList.size(), beforeTestContactsList.size() + 1);

        int maxContactID = afterTestContactsList.stream().mapToInt((c) -> c.getContactID()).max().getAsInt();
        newContact.setContactID(maxContactID);
        beforeTestContactsList.add(newContact);
        Assert.assertEquals(beforeTestContactsList, afterTestContactsList);
    }

}
