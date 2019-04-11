package com.stqa.pft.addressbook.tests;

import com.stqa.pft.addressbook.model.GroupMap;
import org.testng.annotations.*;;

public class GroupCreationTest extends TestBase {

    @Test
    public void testGroupCreation() throws Exception {
        System.out.println("================================================");
        System.out.println("Running testGroupCreation");

        GroupMap testGroup = new GroupMap("test1", "test2", "test3");
//        GroupMap testGroup = new GroupMap("test1", null, null);

        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().createGroup(testGroup);
    }

}




