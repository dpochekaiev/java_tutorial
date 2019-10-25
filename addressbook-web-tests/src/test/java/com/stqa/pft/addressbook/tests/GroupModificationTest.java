package com.stqa.pft.addressbook.tests;

import com.stqa.pft.addressbook.model.GroupMap;
import com.stqa.pft.addressbook.model.Groups;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;


public class GroupModificationTest extends TestBase {

    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeMethod
    public void ensurePreConditions() {
        if (app.db().groups().size() == 0) {
            app.goTo().groupPage();
            app.group().create(new GroupMap().withGroupName("test1").withGroupHeader("Some Dummy Group"));
        }
        /*
        app.goTo().groupPage();
        if (app.group().all().size() == 0) {
            app.group().create(new GroupMap().withGroupName("test1").withGroupHeader("Some Dummy Group"));
        }
        */
    }

    @Test
    public void testGroupModification() {
// preparation part
        logger.warn("================================================");
        logger.warn("Running testGroupModification");
//        System.out.println("================================================");
//        System.out.println("Running testGroupModification");

//        Groups startingTestGroupsList = app.group().all();
//        Groups beforeTestGroupsList = app.group().all();
        Groups beforeTestGroupsList = app.db().groups();
        app.goTo().groupPage();
        GroupMap groupForModification = beforeTestGroupsList.iterator().next();
        GroupMap newGroup = new GroupMap().
                withGroupId(groupForModification.getGroupId()).withGroupName("Edit1").withGroupHeader("Edit_2").withGroupFooter("Edit 3");

// test part
        app.group().modify(newGroup);

// outcoming part
        assertThat(app.group().count(), equalTo(beforeTestGroupsList.size()));
//        Groups afterTestGroupsList = app.group().all();
        Groups afterTestGroupsList = app.db().groups();
        logger.warn("Groups before test: " + beforeTestGroupsList.size());
        for (int i = 0; i <= beforeTestGroupsList.size(); i++) {
            logger.info(beforeTestGroupsList.iterator().next().toString());
        }
        logger.warn("Groups after test: " + afterTestGroupsList.size());
        for (int i = 0; i <= afterTestGroupsList.size(); i++) {
            logger.info(afterTestGroupsList.iterator().next().toString());
        }
//        System.out.println("Initially groups before test: " + startingTestGroupsList.size());
//        System.out.println("Groups before test: " + beforeTestGroupsList.size());
//        System.out.println("Groups after test: " + afterTestGroupsList.size());
        assertThat(afterTestGroupsList, equalTo(beforeTestGroupsList.without(groupForModification).withAdded(newGroup)));
//        System.out.println("Test passed");
        logger.warn("Test passed");
    }


}
