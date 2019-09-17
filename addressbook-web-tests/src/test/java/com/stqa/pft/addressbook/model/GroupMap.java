package com.stqa.pft.addressbook.model;

import java.util.Objects;

public class GroupMap {

    private int groupId = Integer.MAX_VALUE;
    private  String groupName;
    private  String groupHeader;
    private  String groupFooter;

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

    public GroupMap withGroupId(int newGroupID) {
        this.groupId = newGroupID;
        return this;
    }

    public GroupMap withGroupName(String groupName) {
        this.groupName = groupName;
        return this;
    }

    public GroupMap withGroupHeader(String groupHeader) {
        this.groupHeader = groupHeader;
        return this;
    }

    public GroupMap withGroupFooter(String groupFooter) {
        this.groupFooter = groupFooter;
        return this;
    }
}
