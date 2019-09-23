package com.stqa.pft.addressbook.tests;

import com.stqa.pft.addressbook.model.GroupMap;
import com.stqa.pft.addressbook.model.Groups;
import com.thoughtworks.xstream.XStream;
import org.testng.annotations.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class GroupCreationTest extends TestBase {

    @DataProvider
    public Iterator<Object[]> validGroups() throws IOException {
      //  List<Object[]> list = new ArrayList<Object[]>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.xml")));
        String xml = "";
        String line = reader.readLine();
        while (line != null) {
            /*
// Reading the CSV file
            String[] splittedValues = line.split(";");
            list.add(new Object[] {new GroupMap()
                    .withGroupName(splittedValues[0])
                    .withGroupHeader(splittedValues[1])
                    .withGroupFooter(splittedValues[2])});

             */
// Reading the XML file
            xml += line;
            line = reader.readLine();
        }
        XStream xstream = new XStream();
        xstream.processAnnotations(GroupMap.class);
        List<GroupMap> groups = (List<GroupMap>) xstream.fromXML(xml);
// Returning data from the CSV file
      /*  return list.iterator(); */
// Returning data from the XML file
        return groups.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();
    }

    @DataProvider
    public Iterator<Object[]> brokenGroups() throws IOException {
        List<Object[]> list = new ArrayList<Object[]>();
        list.add(new Object[] {new GroupMap()
                .withGroupName("test'1'")
                .withGroupHeader("test2")
                .withGroupFooter("test3")});
        return list.iterator();
    }

    @Test(dataProvider = "validGroups")
    public void testGroupCreation(GroupMap testGroup) throws Exception {
// preparation part
        System.out.println("================================================");
        System.out.println("Running testGroupCreation");
        app.goTo().groupPage();

// test part
        Groups beforeTestGroupsList = app.group().all();
        app.group().create(testGroup);

// outcoming part
        assertThat(app.group().count(), equalTo(beforeTestGroupsList.size() + 1));
        Groups afterTestGroupsList = app.group().all();
        System.out.println("Groups before test: " + beforeTestGroupsList.size());
        System.out.println("Groups after test: " + afterTestGroupsList.size());
        assertThat(afterTestGroupsList, equalTo(
                beforeTestGroupsList.withAdded(testGroup.withGroupId(afterTestGroupsList.stream().mapToInt((g) -> g.getGroupId()).max().getAsInt()))));
    }

    @Test(dataProvider = "brokenGroups")
    public void testBadGroupCreation(GroupMap testGroup) throws Exception {
// preparation part
        System.out.println("================================================");
        System.out.println("Running testGroupCreation");
        app.goTo().groupPage();

// test part
        Groups beforeTestGroupsList = app.group().all();
        app.group().create(testGroup);

// outcoming part
        assertThat(app.group().count(), equalTo(beforeTestGroupsList.size()));
        Groups afterTestGroupsList = app.group().all();
        System.out.println("Groups before test: " + beforeTestGroupsList.size());
        System.out.println("Groups after test: " + afterTestGroupsList.size());
        assertThat(afterTestGroupsList, equalTo(beforeTestGroupsList));
    }

}




