package com.stqa.pft.addressbook.tests;

import com.stqa.pft.addressbook.model.GroupMap;
import com.stqa.pft.addressbook.model.Groups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;


public class GroupModificationTest extends TestBase {

    @BeforeMethod
    public void ensurePreConditions() {
        app.goTo().groupPage();
        if (app.group().all().size() == 0) {
            app.group().create(new GroupMap().withGroupName("test1").withGroupHeader("Some Dummy Group"));
        }
    }

    @Test
    public void testGroupModification() {
// preparation part
        System.out.println("================================================");
        System.out.println("Running testGroupModification");

        Groups startingTestGroupsList = app.group().all();
        Groups beforeTestGroupsList = app.group().all();
        GroupMap groupForModification = beforeTestGroupsList.iterator().next();
        GroupMap newGroup = new GroupMap().
                withGroupId(groupForModification.getGroupId()).withGroupName("Edit1").withGroupHeader("Edit_2").withGroupFooter("Edit 3");

// test part
        app.group().modify(newGroup);

// outcoming part
        assertThat(app.group().count(), equalTo(beforeTestGroupsList.size()));
        Groups afterTestGroupsList = app.group().all();
        System.out.println("Initially groups before test: " + startingTestGroupsList.size());
        System.out.println("Groups before test: " + beforeTestGroupsList.size());
        System.out.println("Groups after test: " + afterTestGroupsList.size());
        assertThat(afterTestGroupsList, equalTo(beforeTestGroupsList.without(groupForModification).withAdded(newGroup)));
    }


}
