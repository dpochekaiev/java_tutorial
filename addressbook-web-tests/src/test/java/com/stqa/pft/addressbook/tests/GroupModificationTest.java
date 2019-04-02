package com.stqa.pft.addressbook.tests;

import com.stqa.pft.addressbook.model.GroupMap;
import org.testng.annotations.Test;

public class GroupModificationTest extends TestBase {

    @Test
    public void testGroupModification() {
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupMap("Edit1", "Edit_2", "Edit 3"));
        app.getGroupHelper().submitGroupUpate();
        app.getGroupHelper().returnToGroupPage();
    }

}
