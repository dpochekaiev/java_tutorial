package com.stqa.pft.addressbook.tests;

import com.stqa.pft.addressbook.model.GroupMap;
import org.testng.Assert;
import org.testng.annotations.*;;import java.util.HashSet;
import java.util.List;

public class GroupCreationTest extends TestBase {

    @Test
    public void testGroupCreation() throws Exception {
// preparation part
        System.out.println("================================================");
        System.out.println("Running testGroupCreation");

        GroupMap testGroup = new GroupMap("test1", "test2", "test3");
        //GroupMap testGroup = new GroupMap("test1", null, null);
        app.getNavigationHelper().gotoGroupPage();

// test part
        List<GroupMap> beforeTestGroupsList = app.getGroupHelper().getGroupList();
        app.getGroupHelper().createGroup(testGroup);

// outcoming part
        List<GroupMap> afterTestGroupsList = app.getGroupHelper().getGroupList();
        System.out.println("Groups before test: " + beforeTestGroupsList.size());
        System.out.println("Groups after test: " + afterTestGroupsList.size());
        Assert.assertEquals(afterTestGroupsList.size(), beforeTestGroupsList.size() + 1);

        int maxGroupID = 0;
        for (GroupMap i : afterTestGroupsList) {
            if (maxGroupID < i.getGroupId()) {
                maxGroupID = i.getGroupId();
            }
        }
        testGroup.setGroupId(maxGroupID);
        beforeTestGroupsList.add(testGroup);
        Assert.assertEquals(new HashSet<Object>(afterTestGroupsList), new HashSet<Object>(beforeTestGroupsList));
        //TODO: :remove redundant lines
        System.out.println();
        System.out.println("beforeTestGroupsList" + "                              " + "afterTestGroupsList");
        for (int i = 0; i < afterTestGroupsList.size(); i++) {
            System.out.println(beforeTestGroupsList.get(i) + "    " + afterTestGroupsList.get(i));
        }
        //TODO: :end of redundant lines
    }

}




