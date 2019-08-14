package com.stqa.pft.addressbook.tests;

        import com.stqa.pft.addressbook.model.AccountMap;
        import org.testng.Assert;
        import org.testng.annotations.*;

        import java.util.Comparator;
        import java.util.List;

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
        /*
        AccountMap newContact = new AccountMap(
                "First",
                "M",
                "Surname",
                "Company",
                "Address",
                "5551234567",
                "dummy@mail.dot",
                "1",
                "January",
                "1900",
                "test1");
                */

//        AccountMap newContact = new AccountMap(
//                "Name",
//                "",
//                "Last",
//                "",
//                null,
//                "",
//                "dummy@mail.dot",
//                "",
//                null,
//                "1988",
//                "test1" );

// test part
        app.goTo().homePage();
        List<AccountMap> beforeTestContactsList = app.contact().list();
        app.contact().create(newContact, true);

// outcoming part
        List<AccountMap> afterTestContactsList = app.contact().list();
        System.out.println("Contacts before test: " + beforeTestContactsList.size());
        System.out.println("Contacts after test: " + afterTestContactsList.size());
        Assert.assertEquals(afterTestContactsList.size(), beforeTestContactsList.size() + 1);

        int maxContactID = afterTestContactsList.stream().max((o1, o2) -> Integer.compare(o1.getContactID(), o2.getContactID())).get().getContactID();
        newContact.setContactID(maxContactID);
        beforeTestContactsList.add(newContact);
        //TODO: :remove redundant lines
        beforeTestContactsList = app.contact().sortAscending(beforeTestContactsList);
        afterTestContactsList = app.contact().sortAscending(afterTestContactsList);
        System.out.println();
        System.out.println("Comparing: beforeTestGroupsList and" + " " + "afterTestGroupsList");
        for (int i = 0; i < afterTestContactsList.size(); i++) {
//            System.out.println(beforeTestContactsList.get(i) + "        " + afterTestContactsList.get(i));
            System.out.println("    Record № " + i);
            System.out.println("before: " + beforeTestContactsList.get(i));
            System.out.println("after:  " + afterTestContactsList.get(i));
            System.out.println();
        }
        //TODO: :end of redundant lines

        Comparator<? super AccountMap> byContactID = (g1, g2) -> Integer.compare(g1.getContactID(), g2.getContactID());
        beforeTestContactsList.sort(byContactID);
        afterTestContactsList.sort(byContactID);
        Assert.assertEquals(beforeTestContactsList, afterTestContactsList);
    }

}
