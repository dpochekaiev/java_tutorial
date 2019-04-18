package com.stqa.pft.addressbook.tests;

import com.stqa.pft.addressbook.model.GroupMap;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupRemoveTest extends TestBase {

    @Test
    public void testRemoveGroup() throws Exception {
// preparation part
        System.out.println("================================================");
        System.out.println("Running testRemoveGroup");

        app.getNavigationHelper().gotoGroupPage();
        int startingTestGroupCount = app.getGroupHelper().getGroupCount();

        if (!app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new GroupMap("test1", null, null));
        }
        int beforeTestGroupsCount = app.getGroupHelper().getGroupCount();

// test part
        app.getGroupHelper().selectGroupByIndex(0);
        app.getGroupHelper().deleteSelectedGroups();
        app.getGroupHelper().returnToGroupPage();

// outcoming part
        int afterTestGroupsCount = app.getGroupHelper().getGroupCount();
        System.out.println("Initially groups before test: " + startingTestGroupCount);
        System.out.println("Groups before test: " + beforeTestGroupsCount);
        System.out.println("Groups after test: " + afterTestGroupsCount);
        Assert.assertEquals(afterTestGroupsCount, beforeTestGroupsCount - 1);
    }

}
