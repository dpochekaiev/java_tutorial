package com.stqa.pft.addressbook.tests;

        import com.stqa.pft.addressbook.model.AccountMap;
        import org.testng.annotations.*;

public class ContactCreationTest extends TestBase {

    @Test
    public void testContactCreation() throws Exception {

        app.getContactHelper().initContactCreation();
//        app.getContactHelper().fillContactForm(new AccountMap(
//                "First",
//                "M",
//                "Surname",
//                "Company",
//                "Address",
//                "5551234567",
//                "dummy@mail.dot",
//                "1",
//                "January",
//                "1900"));

        app.getContactHelper().fillContactForm(new AccountMap(
                "Name",
                "",
                "Last",
                "",
                null,
                "",
                "dummy@mail.dot",
                "",
                null,
                "1988"));

        app.getContactHelper().submitContactCreation();
        app.getContactHelper().returnToMainPage();
    }

}
