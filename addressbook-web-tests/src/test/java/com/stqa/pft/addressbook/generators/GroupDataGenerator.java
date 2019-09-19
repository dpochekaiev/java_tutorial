package com.stqa.pft.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.stqa.pft.addressbook.model.GroupMap;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class GroupDataGenerator {

    @Parameter(names = "-c", description = "Groups count")
    public int groupsDataCount = 6;

    @Parameter(names = "-f", description = "Groups data target filename")
    public String groupsDataFileName = "src/test/resources/default_groups_test.csv";


    public static void main(String[] args) throws IOException {
        GroupDataGenerator generator = new GroupDataGenerator();
        JCommander jCommender = new JCommander(generator);
        try {
            jCommender.parse(args);
        } catch (ParameterException ex) {
            jCommender.usage();
            return;
        }
        generator.run();
    }

    private void run() throws IOException {
        List<GroupMap> groups = generateGroups(groupsDataCount);
        save(groups, new File(groupsDataFileName));
    }

    private void save(List<GroupMap> groups, File groupsFile) throws IOException {
        Writer writer = new FileWriter(groupsFile);
        for (GroupMap group : groups) {
            writer.write(String.format("%s;%s;%s\n", group.getGroupName(), group.getGroupHeader(), group.getGroupFooter()));
        }
        writer.close();
    }

    private List<GroupMap> generateGroups(int amountOfGroups) {
        List<GroupMap> groups = new ArrayList<GroupMap>();
        for (int i = 0; i < amountOfGroups; i++) {
            groups.add(new GroupMap().withGroupName(String.format("test %s", i))
                    .withGroupHeader(String.format("header %s", i))
                    .withGroupFooter(String.format("footer %s", i)));
        }
        return groups;
    }
}
