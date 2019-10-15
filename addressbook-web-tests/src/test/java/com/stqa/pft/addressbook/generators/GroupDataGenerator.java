package com.stqa.pft.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.stqa.pft.addressbook.model.GroupMap;
import com.thoughtworks.xstream.XStream;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class GroupDataGenerator {

    // program arguments:
    // -c 2 -f src/test/resources/groups -d json
    @Parameter(names = "-c", description = "Groups count")
    public int groupsDataCount;

    @Parameter(names = "-f", description = "Groups data target filename")
    public String groupsDataFileName;

    @Parameter(names = "-d", description = "Groups data target file format: csv, xml, json")
    public String groupsDataFileFormat;


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
        if (groupsDataFileFormat.equals("csv")) {
            saveAsCsv(groups, new File(groupsDataFileName + "." + groupsDataFileFormat));
        } else if  (groupsDataFileFormat.equals("xml")) {
            saveAsXml(groups, new File(groupsDataFileName + "." + groupsDataFileFormat));
        } else if  (groupsDataFileFormat.equals("json")) {
            saveAsJson(groups, new File(groupsDataFileName + "." + groupsDataFileFormat));
        } else {
            System.out.println("Unknown file format: " + groupsDataFileFormat);
        }
    }

    private void saveAsJson(List<GroupMap> groups, File file) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
        String json = gson.toJson(groups);
        try (Writer writer = new FileWriter(file)) {
            writer.write(json);
            // writer.close(); -- redundant operation, as the writer was initialised in the "try" block and don't need the closing action
        }
    }

    private void saveAsXml(List<GroupMap> groups, File file) throws IOException {
        XStream xstream = new XStream();
        xstream.processAnnotations(GroupMap.class);
        String xml = xstream.toXML(groups);
        try (Writer writer = new FileWriter(file)) {
            writer.write(xml);
            // writer.close(); -- redundant operation, as the writer was initialised in the "try" block and don't need the closing action
        }
    }

    private void saveAsCsv(List<GroupMap> groups, File groupsFile) throws IOException {
        try (Writer writer = new FileWriter(groupsFile)) {
            for (GroupMap group : groups) {
                writer.write(String.format("%s;%s;%s\n", group.getGroupName(), group.getGroupHeader(), group.getGroupFooter()));
            }
        }
        // writer.close(); -- redundant operation, as the writer was initialised in the "try" block and don't need the closing action
    }

    private List<GroupMap> generateGroups(int amountOfGroups) {
        List<GroupMap> groups = new ArrayList<GroupMap>();
        for (int i = 0; i < amountOfGroups; i++) {
            groups.add(new GroupMap().withGroupName(String.format("test %s", i))
                    .withGroupHeader(String.format("header \n%s", i))
                    .withGroupFooter(String.format("footer \n%s", i)));
        }
        return groups;
    }
}
