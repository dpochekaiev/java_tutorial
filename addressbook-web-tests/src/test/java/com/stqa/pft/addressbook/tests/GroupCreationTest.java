package com.stqa.pft.addressbook.tests;

import com.stqa.pft.addressbook.model.GroupMap;
import com.stqa.pft.addressbook.model.Groups;
import org.testng.annotations.*;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class GroupCreationTest extends TestBase {

    @Test
    public void testGroupCreation() throws Exception {
// preparation part
        System.out.println("================================================");
        System.out.println("Running testGroupCreation");
        GroupMap testGroup = new GroupMap().withGroupName("test1").withGroupHeader("test2").withGroupFooter("test3");
        app.goTo().groupPage();

// test part
        Groups beforeTestGroupsList = app.group().all();
        app.group().create(testGroup);

// outcoming part
        Groups afterTestGroupsList = app.group().all();
        System.out.println("Groups before test: " + beforeTestGroupsList.size());
        System.out.println("Groups after test: " + afterTestGroupsList.size());
        assertThat(afterTestGroupsList.size(), equalTo(beforeTestGroupsList.size() + 1));
        assertThat(afterTestGroupsList, equalTo(
                beforeTestGroupsList.withAdded(testGroup.withGroupId(afterTestGroupsList.stream().mapToInt((g) -> g.getGroupId()).max().getAsInt()))));
    }

}




