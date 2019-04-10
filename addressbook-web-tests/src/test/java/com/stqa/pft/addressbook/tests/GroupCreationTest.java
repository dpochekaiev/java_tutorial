package com.stqa.pft.addressbook.tests;

import com.stqa.pft.addressbook.model.GroupMap;
import org.testng.annotations.*;;

public class GroupCreationTest extends TestBase {

    @Test
    public void testGroupCreation() throws Exception {
        GroupMap testGroup = new GroupMap("test1", "test2", "test3");
//        GroupMap testGroup = new GroupMap("test1", null, null);

        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().createGroup(testGroup);

//TODO: :The following lines are replaced with the single method above

//        app.getGroupHelper().initGroupCreation();
//        app.getGroupHelper().fillGroupForm(testGroup);
//        app.getGroupHelper().submitGroupCreation();
//        app.getGroupHelper().returnToGroupPage();
    }

}




