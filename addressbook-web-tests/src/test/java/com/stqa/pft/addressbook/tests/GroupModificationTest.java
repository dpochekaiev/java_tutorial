package com.stqa.pft.addressbook.tests;

import com.stqa.pft.addressbook.model.GroupMap;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class GroupModificationTest extends TestBase {

    @Test
    public void testGroupModification() {
// preparation part
        System.out.println("================================================");
        System.out.println("Running testGroupModification");

        app.getNavigationHelper().gotoGroupPage();
        List<GroupMap> startingTestGroupsList = app.getGroupHelper().getGroupList();
        if (!app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new GroupMap("test1", null, null));
        }
        List<GroupMap> beforeTestGroupsList = app.getGroupHelper().getGroupList();

// test part
        app.getGroupHelper().selectGroupByIndex(beforeTestGroupsList.size() - 1);  // the last group
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupMap("Edit1", "Edit_2", "Edit 3"));
        app.getGroupHelper().submitGroupUpate();
        app.getGroupHelper().returnToGroupPage();

// outcoming part
        List<GroupMap> afterTestGroupsList = app.getGroupHelper().getGroupList();
        System.out.println("Initially groups before test: " + startingTestGroupsList.size());
        System.out.println("Groups before test: " + beforeTestGroupsList.size());
        System.out.println("Groups after test: " + afterTestGroupsList.size());
        Assert.assertEquals(afterTestGroupsList.size(), beforeTestGroupsList.size());
    }

}
