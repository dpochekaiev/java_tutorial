package com.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class GroupRemoveTest extends TestBase {

    @Test
    public void testRemoveGroup() throws Exception {
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().deleteSelectedGroups();
        app.getGroupHelper().returnToGroupPage();
    }

}
