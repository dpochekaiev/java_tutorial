package com.stqa.pft.addressbook.tests;

import com.stqa.pft.addressbook.model.GroupMap;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.Set;

public class GroupCreationTest extends TestBase {

    @Test
    public void testGroupCreation() throws Exception {
// preparation part
        System.out.println("================================================");
        System.out.println("Running testGroupCreation");
        GroupMap testGroup = new GroupMap().withGroupName("test1").withGroupHeader("test2").withGroupFooter("test3");
        app.goTo().groupPage();

// test part
        Set<GroupMap> beforeTestGroupsList = app.group().all();
        app.group().create(testGroup);

// outcoming part
        Set<GroupMap> afterTestGroupsList = app.group().all();
        System.out.println("Groups before test: " + beforeTestGroupsList.size());
        System.out.println("Groups after test: " + afterTestGroupsList.size());
        Assert.assertEquals(afterTestGroupsList.size(), beforeTestGroupsList.size() + 1);

        testGroup.withGroupId(afterTestGroupsList.stream().mapToInt((g) -> g.getGroupId()).max().getAsInt());
        beforeTestGroupsList.add(testGroup);
        Assert.assertEquals(beforeTestGroupsList, afterTestGroupsList);
    }

}




