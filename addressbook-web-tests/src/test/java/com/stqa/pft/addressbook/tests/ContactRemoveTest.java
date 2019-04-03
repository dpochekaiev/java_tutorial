package com.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactRemoveTest extends TestBase {

    @Test
    public void testContactRemove() {
        app.getNavigationHelper().gotoHomePage();
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteSelectedContact();
        app.getNavigationHelper().gotoHomePage();
    }

}
