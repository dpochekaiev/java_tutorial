package com.stqa.pft.addressbook.tests;

import com.stqa.pft.addressbook.model.GroupMap;
import com.stqa.pft.addressbook.model.Groups;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class GroupRemoveTest extends TestBase {

    private int selectedGroupIndex = 0;

    @BeforeMethod
    public void ensurePreConditions() {
        app.goTo().groupPage();
        if (app.group().all().size() == 0) {
            app.group().create(new GroupMap().withGroupName("test1").withGroupHeader("Some Dummy Group"));
        }
    }

    @Test
    public void testRemoveGroup() throws Exception {
// preparation part
        System.out.println("================================================");
        System.out.println("Running testRemoveGroup");
        Groups beforeTestGroupsList = app.group().all();
        GroupMap groupForDeletion = beforeTestGroupsList.iterator().next();

// test part
        app.group().delete(groupForDeletion);

// outcoming part
        assertThat(app.group().count(), equalTo(beforeTestGroupsList.size() - 1));
        Groups afterTestGroupsList = app.group().all();
        System.out.println("Groups before test: " + beforeTestGroupsList.size());
        System.out.println("Groups after test: " + afterTestGroupsList.size());
        assertThat(afterTestGroupsList, equalTo(beforeTestGroupsList.without(groupForDeletion)));
    }

}
