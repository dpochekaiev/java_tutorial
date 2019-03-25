package com.stqa.pft.addressbook;

        import org.testng.annotations.*;

public class AccountCreationTest extends TestBase {

    @Test
    public void testUntitledTestCase() throws Exception {

        initAccountCreation();
        fillAccountForm(new AccountMap("First", "M", "Surname", "Company", "Address", "5551234567", "dummy@mail.dot", "1", "January", "1900"));
        submitAccountCreation();
    }

}
