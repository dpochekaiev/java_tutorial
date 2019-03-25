package com.stqa.pft.addressbook;

import org.testng.annotations.*;;

public class GroupCreationTest extends TestBase{

    @Test
    public void testGroupCreation() throws Exception {
        GroupMap testGroup = new GroupMap("test1", "test2", "test3");

        gotoGroupCreation();
        initGroupCreation();
        fillGroupForm(testGroup);
        submitGroupCreation();
        //
        //TODO: :remove this block after experiments been completed. Creating a second group: without header and footer
        gotoGroupCreation();
        initGroupCreation();
        fillGroupForm("groupWithEmptyHeaderAndFooter");
        submitGroupCreation();
        //
        returnToGroupPage();
    }

}




