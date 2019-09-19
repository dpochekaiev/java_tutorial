package com.stqa.pft.addressbook.generators;

import com.stqa.pft.addressbook.model.GroupMap;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class GroupDataGenerator {

    public static void main(String[] args) throws IOException {
        int amountOfGroups = Integer.parseInt(args[0]);
        File groupsFile = new File(args[1]);

        List<GroupMap> groups = generateGroups(amountOfGroups);
        save(groups, groupsFile);
    }

    private static void save(List<GroupMap> groups, File groupsFile) throws IOException {

        System.out.println(new File(".").getAbsolutePath());

        Writer writer = new FileWriter(groupsFile);
        for (GroupMap group : groups) {
            writer.write(String.format("%s;%s;%s\n", group.getGroupName(), group.getGroupHeader(), group.getGroupFooter()));
        }
        writer.close();
    }

    private static List<GroupMap> generateGroups(int amountOfGroups) {
        List<GroupMap> groups = new ArrayList<GroupMap>();
        for (int i = 0; i < amountOfGroups; i++) {
            groups.add(new GroupMap().withGroupName(String.format("test %s", i))
                    .withGroupHeader(String.format("header %s", i))
                    .withGroupFooter(String.format("footer %s", i)));
        }
        return groups;
    }
}
