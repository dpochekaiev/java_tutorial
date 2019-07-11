package com.stqa.pft.addressbook.tests;

import com.stqa.pft.addressbook.model.GroupMap;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Comparator;
import java.util.List;

public class GroupCreationTest extends TestBase {

    @Test
    public void testGroupCreation() throws Exception {
// preparation part
        System.out.println("================================================");
        System.out.println("Running testGroupCreation");

        GroupMap testGroup = new GroupMap("test1", "test2", "test3");
        //GroupMap testGroup = new GroupMap("test1", null, null);
        app.goTo().groupPage();

// test part
        List<GroupMap> beforeTestGroupsList = app.group().list();
        app.group().create(testGroup);

// outcoming part
        List<GroupMap> afterTestGroupsList = app.group().list();
        System.out.println("Groups before test: " + beforeTestGroupsList.size());
        System.out.println("Groups after test: " + afterTestGroupsList.size());
        Assert.assertEquals(afterTestGroupsList.size(), beforeTestGroupsList.size() + 1);

//        int maxGroupID = 0;
//        for (GroupMap i : afterTestGroupsList) {
//            if (maxGroupID < i.getGroupId()) {
//                maxGroupID = i.getGroupId();
//            }
//        }

//        /**
//         * анонимный класс
//         */
//        Comparator<? super GroupMap> byId = new Comparator<GroupMap>() {
//            @Override
//            public int compare(GroupMap o1, GroupMap o2) {
//                return Integer.compare(o1.getGroupId(), o2.getGroupId());
//            }
//        };
//        int maxGroupID = afterTestGroupsList.stream().max(byId).get().getGroupId();

//        /**
//         * анонимная функция
//         */
//        Comparator<? super GroupMap> byId = (Comparator<GroupMap>) (o1, o2) -> Integer.compare(o1.getGroupId(), o2.getGroupId());
//        int maxGroupID = afterTestGroupsList.stream().max(byId).get().getGroupId();

        /**
         * испоьзование лябда-выражения (анонимной функции) для получения максимального значения groupID
         */
        int maxGroupID = afterTestGroupsList.stream().max((o1, o2) -> Integer.compare(o1.getGroupId(), o2.getGroupId())).get().getGroupId();
        testGroup.setGroupId(maxGroupID);
        beforeTestGroupsList.add(testGroup);
        Comparator<? super GroupMap> byGroupID = (g1, g2) -> Integer.compare(g1.getGroupId(), g2.getGroupId());
        beforeTestGroupsList.sort(byGroupID);
        afterTestGroupsList.sort(byGroupID);
        Assert.assertEquals(beforeTestGroupsList, afterTestGroupsList);

        //TODO: :remove redundant lines
        System.out.println();
        System.out.println("beforeTestGroupsList" + "                              " + "afterTestGroupsList");
        for (int i = 0; i < afterTestGroupsList.size(); i++) {
            System.out.println(beforeTestGroupsList.get(i) + "    " + afterTestGroupsList.get(i));
        }
        //TODO: :end of redundant lines
    }

}




