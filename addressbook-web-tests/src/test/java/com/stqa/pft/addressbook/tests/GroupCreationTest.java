package com.stqa.pft.addressbook.tests;

import com.stqa.pft.addressbook.model.GroupMap;
import org.testng.Assert;
import org.testng.annotations.*;;

public class GroupCreationTest extends TestBase {

    @Test
    public void testGroupCreation() throws Exception {
// preparation part
        System.out.println("================================================");
        System.out.println("Running testGroupCreation");

        GroupMap testGroup = new GroupMap("test1", "test2", "test3");
        //GroupMap testGroup = new GroupMap("test1", null, null);

// test part
        app.getNavigationHelper().gotoGroupPage();
        int beforeTestGroupsCount = app.getGroupHelper().getGroupCount();
        app.getGroupHelper().createGroup(testGroup);

// outcoming part
        int afterTestGroupsCount = app.getGroupHelper().getGroupCount();
        System.out.println("Groups before test: " + beforeTestGroupsCount);
        System.out.println("Groups after test: " + afterTestGroupsCount);
        Assert.assertEquals(afterTestGroupsCount, beforeTestGroupsCount + 1);
    }

}




