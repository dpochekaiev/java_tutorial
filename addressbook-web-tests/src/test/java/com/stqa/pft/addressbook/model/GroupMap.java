package com.stqa.pft.addressbook.model;

import java.util.Objects;

public class GroupMap {
    private final String groupName;
    private final String groupHeader;
    private final String groupFooter;

    public GroupMap(String groupName, String groupHeader, String groupFooter) {
        this.groupName = groupName;
        this.groupHeader = groupHeader;
        this.groupFooter = groupFooter;
    }

    public String getGroupName() {
        return groupName;
    }

    public String getGroupHeader() {
        return groupHeader;
    }

    public String getGroupFooter() {
        return groupFooter;
    }

    @Override
    public String toString() {
        return "GroupMap{" +
                "groupName='" + groupName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupMap groupMap = (GroupMap) o;
        return Objects.equals(groupName, groupMap.groupName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupName);
    }
}
