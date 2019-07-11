package com.stqa.pft.addressbook.tests;

import com.stqa.pft.addressbook.model.GroupMap;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;


public class GroupModificationTest extends TestBase {

    @BeforeMethod
    public void ensurePreConditions() {
        app.goTo().groupPage();
        if (app.group().list().size() == 0) {
            app.group().create(new GroupMap("test1", "Some Dummy Group", null));
        }
    }

    @Test
    public void testGroupModification() {
// preparation part
        System.out.println("================================================");
        System.out.println("Running testGroupModification");

        List<GroupMap> startingTestGroupsList = app.group().list();
        List<GroupMap> beforeTestGroupsList = app.group().list();

        int selectedGroupIndex = beforeTestGroupsList.size() - 1;
        GroupMap newGroup = new GroupMap(beforeTestGroupsList.get(selectedGroupIndex).getGroupId(), "Edit1", "Edit_2", "Edit 3");

// test part
        app.group().modify(selectedGroupIndex, newGroup);

// outcoming part
        List<GroupMap> afterTestGroupsList = app.group().list();
        System.out.println("Initially groups before test: " + startingTestGroupsList.size());
        System.out.println("Groups before test: " + beforeTestGroupsList.size());
        System.out.println("Groups after test: " + afterTestGroupsList.size());
        Assert.assertEquals(afterTestGroupsList.size(), beforeTestGroupsList.size());

        beforeTestGroupsList.remove(selectedGroupIndex);
        beforeTestGroupsList.add(newGroup);
        Comparator<? super GroupMap> byGroupID = (g1, g2) -> Integer.compare(g1.getGroupId(), g2.getGroupId());
        beforeTestGroupsList.sort(byGroupID);
        afterTestGroupsList.sort(byGroupID);
        //TODO: :remove redundant lines
        System.out.println();
        System.out.println("beforeTestGroupsList" + "                              " + "afterTestGroupsList");
        for (int i = 0; i < afterTestGroupsList.size(); i++) {
            System.out.println(beforeTestGroupsList.get(i) + "    " + afterTestGroupsList.get(i));
        }
        //TODO: :end of redundant lines
        Assert.assertEquals(beforeTestGroupsList, afterTestGroupsList);;
    }


}
