package com.stqa.pft.addressbook.model;

import java.util.Objects;

public class GroupMap {

    private int groupId;
    private final String groupName;
    private final String groupHeader;
    private final String groupFooter;

    public GroupMap(String groupName, String groupHeader, String groupFooter) {
        this.groupId = 0;
        this.groupName = groupName;
        this.groupHeader = groupHeader;
        this.groupFooter = groupFooter;
    }
    public GroupMap(int groupId, String groupName, String groupHeader, String groupFooter) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.groupHeader = groupHeader;
        this.groupFooter = groupFooter;
    }

    public int getGroupId() {
        return groupId;
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
                "groupId='" + groupId + '\'' +
                ", groupName='" + groupName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupMap groupMap = (GroupMap) o;
        return groupId == groupMap.groupId &&
                Objects.equals(groupName, groupMap.groupName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupId, groupName);
    }

    public void setGroupId(int newGroupID) {
        this.groupId = newGroupID;
    }
}
