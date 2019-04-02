package com.stqa.pft.addressbook.tests;

        import com.stqa.pft.addressbook.model.AccountMap;
        import org.testng.annotations.*;

public class AccountCreationTest extends TestBase {

    @Test
    public void testUntitledTestCase() throws Exception {

        app.getContactHelper().initAccountCreation();
//        app.getContactHelper().fillAccountForm(new AccountMap("First", "M", "Surname", "Company", "Address", "5551234567", "dummy@mail.dot", "1", "January", "1900"));
        app.getContactHelper().fillAccountForm(new AccountMap("Name", "", "Last", "", "", "", "dummy@mail.dot", "2", "February", "1988"));
        app.getContactHelper().submitAccountCreation();
    }

}
