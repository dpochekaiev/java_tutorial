package com.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class GroupRemoveTest extends TestBase{

    @Test
    public void testRemoveGroup() throws Exception {
        gotoGroupCreation();
        selectGroup();
        deleteSelectedGroups();
        returnToGroupPage();
    }

}
