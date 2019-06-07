package com.stqa.pft.addressbook.tests;

        import com.stqa.pft.addressbook.model.AccountMap;
        import org.testng.Assert;
        import org.testng.annotations.*;

        import java.util.HashSet;
        import java.util.List;

public class ContactCreationTest extends TestBase {

    @Test
    public void testContactCreation() throws Exception {
// preparation part
        System.out.println("================================================");
        System.out.println("Running testContactCreation");
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
        app.getNavigationHelper().gotoHomePage();
        List<AccountMap> beforeTestContactsList = app.getContactHelper().getContactList();
        app.getContactHelper().createContact(newContact, true);

// outcoming part
        List<AccountMap> afterTestContactsList = app.getContactHelper().getContactList();
        System.out.println("Contacts before test: " + beforeTestContactsList.size());
        System.out.println("Contacts after test: " + afterTestContactsList.size());
        Assert.assertEquals(afterTestContactsList.size(), beforeTestContactsList.size() + 1);

//        int maxContactID = 0;
//        for (AccountMap contact : afterTestContactsList) {
//            if (contact.getContactID() > maxContactID) {
//                maxContactID = contact.getContactID();
//            }
//        }

        int maxContactID = afterTestContactsList.stream().max((o1, o2) -> Integer.compare(o1.getContactID(), o2.getContactID())).get().getContactID();
        newContact.setContactID(maxContactID);
        beforeTestContactsList.add(newContact);
        //TODO: :remove redundant lines
        beforeTestContactsList = app.getContactHelper().sortAscending(beforeTestContactsList);
        afterTestContactsList = app.getContactHelper().sortAscending(afterTestContactsList);
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
//        List<AccountMap> beforeTestContactsListArranged = new AccountMap;
//        List<AccountMap> afterTestContactsListArranged = new AccountMap;
//        *
//        // тут надо написать способ получения упорядоченных массивов контактов по возрастанию contactID
//
//        int minAccountID = 0;
//        for (int i = 0; i < afterTestContactsList.size(); i++) {
//            for (int j = 0; j < i; j++) {
//                if (minAccountID <= beforeTestContactsList.get(j).getContactID()) {
//                    maxContactID = beforeTestContactsList.get(j).getContactID();
//                    *
//                     * и что-то ещё в том же духе
//
//                }
//            }
//        }

        Assert.assertEquals(new HashSet<Object>(afterTestContactsList), new HashSet<Object>(beforeTestContactsList));
    }

}
