package com.stqa.pft.addressbook.tests;

import com.stqa.pft.addressbook.model.GroupMap;
import org.testng.annotations.*;;

public class GroupCreationTest extends TestBase {

    @Test
    public void testGroupCreation() throws Exception {
        GroupMap testGroup = new GroupMap("test1", "test2", "test3");

        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(testGroup);
        app.getGroupHelper().submitGroupCreation();
        //
        //TODO: :remove this block after experiments been completed. Creating a second group: without header and footer
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm("groupWithEmptyHeaderAndFooter");
        app.getGroupHelper().submitGroupCreation();
        //
        app.getGroupHelper().returnToGroupPage();
    }

}




