package com.stqa.pft.addressbook.tests;

import com.stqa.pft.addressbook.model.GroupMap;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class GroupRemoveTest extends TestBase {

    private int selectedGroupIndex = 0;

    @BeforeMethod
    public void ensurePreConditions() {
        app.goTo().groupPage();
        if (!app.group().isThereAGroup()) {
            app.group().create(new GroupMap().withGroupName("test1").withGroupHeader("Some Dummy Group"));
        }
    }

    @Test
    public void testRemoveGroup() throws Exception {
// preparation part
        System.out.println("================================================");
        System.out.println("Running testRemoveGroup");

        List<GroupMap> beforeTestGroupsList = app.group().list();

// test part
        app.group().delete(selectedGroupIndex);

// outcoming part
        List<GroupMap> afterTestGroupsList = app.group().list();
        System.out.println("Groups before test: " + beforeTestGroupsList.size());
        System.out.println("Groups after test: " + afterTestGroupsList.size());
        Assert.assertEquals(afterTestGroupsList.size(), beforeTestGroupsList.size() - 1);

        beforeTestGroupsList.remove(selectedGroupIndex);
        Comparator<? super GroupMap> byGroupID = (g1, g2) -> Integer.compare(g1.getGroupId(), g2.getGroupId());
        beforeTestGroupsList.sort(byGroupID);
        afterTestGroupsList.sort(byGroupID);
        Assert.assertEquals(beforeTestGroupsList, afterTestGroupsList);

        //TODO: :remove redundant lines
        System.out.println();
        System.out.println("beforeTestGroupsList" + "               " + "afterTestGroupsList");
        for (int i = 0; i < afterTestGroupsList.size(); i++) {
            System.out.println(beforeTestGroupsList.get(i) + "    " + afterTestGroupsList.get(i));
        }
        //TODO: :end of redundant lines
    }

}
