package com.stqa.pft.addressbook.tests;

import com.stqa.pft.addressbook.model.GroupMap;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.HashSet;
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

        int selectedGroupIndex = beforeTestGroupsList.size() - 1;
        GroupMap newGroup = new GroupMap(beforeTestGroupsList.get(selectedGroupIndex).getGroupId(), "Edit1", "Edit_2", "Edit 3");

// test part
        app.getGroupHelper().selectGroupByIndex(selectedGroupIndex);  // the last group
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(newGroup);
        app.getGroupHelper().submitGroupUpate();
        app.getGroupHelper().returnToGroupPage();

// outcoming part
        List<GroupMap> afterTestGroupsList = app.getGroupHelper().getGroupList();
        System.out.println("Initially groups before test: " + startingTestGroupsList.size());
        System.out.println("Groups before test: " + beforeTestGroupsList.size());
        System.out.println("Groups after test: " + afterTestGroupsList.size());
        Assert.assertEquals(afterTestGroupsList.size(), beforeTestGroupsList.size());

        beforeTestGroupsList.remove(selectedGroupIndex);
        beforeTestGroupsList.add(newGroup);
        Comparator<? super GroupMap> byGroupID = (g1, g2) -> Integer.compare(g1.getGroupId(), g2.getGroupId());
        beforeTestGroupsList.sort(byGroupID);
        afterTestGroupsList.sort(byGroupID);
        Assert.assertEquals(beforeTestGroupsList, afterTestGroupsList);;

        //TODO: :remove redundant lines
        System.out.println();
        System.out.println("beforeTestGroupsList" + "                              " + "afterTestGroupsList");
        for (int i = 0; i < afterTestGroupsList.size(); i++) {
            System.out.println(beforeTestGroupsList.get(i) + "    " + afterTestGroupsList.get(i));
        }
        //TODO: :end of redundant lines
    }

}
