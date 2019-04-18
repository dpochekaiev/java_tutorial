package com.stqa.pft.addressbook.tests;

import com.stqa.pft.addressbook.model.GroupMap;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class GroupRemoveTest extends TestBase {

    @Test
    public void testRemoveGroup() throws Exception {
// preparation part
        System.out.println("================================================");
        System.out.println("Running testRemoveGroup");

        app.getNavigationHelper().gotoGroupPage();
        List<GroupMap> startingTestGroupsList = app.getGroupHelper().getGroupList();
//        int startingTestGroupCount = app.getGroupHelper().getGroupCount();

        if (!app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new GroupMap("test1", null, null));
        }
        List<GroupMap> beforeTestGroupsList = app.getGroupHelper().getGroupList();
//        int beforeTestGroupsCount = app.getGroupHelper().getGroupCount();

// test part
        app.getGroupHelper().selectGroupByIndex(0);
        app.getGroupHelper().deleteSelectedGroups();
        app.getGroupHelper().returnToGroupPage();

// outcoming part
        List<GroupMap> afterTestGroupsList = app.getGroupHelper().getGroupList();
//        int afterTestGroupsCount = app.getGroupHelper().getGroupCount();
        System.out.println("Initially groups before test: " + startingTestGroupsList.size());
        System.out.println("Groups before test: " + beforeTestGroupsList.size());
        System.out.println("Groups after test: " + afterTestGroupsList.size());
        Assert.assertEquals(afterTestGroupsList.size(), beforeTestGroupsList.size() - 1);
    }

}
