package com.stqa.pft.addressbook.tests;

        import com.stqa.pft.addressbook.model.AccountMap;
        import org.testng.annotations.*;

public class ContactCreationTest extends TestBase {

    @Test
    public void testContactCreation() throws Exception {
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

        app.getContactHelper().createContact(newContact, true);

    }

}
