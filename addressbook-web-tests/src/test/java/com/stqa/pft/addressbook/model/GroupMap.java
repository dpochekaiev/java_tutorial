package com.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import java.util.Objects;

@XStreamAlias("group")
public class GroupMap {
    @XStreamOmitField
    private int groupId = Integer.MAX_VALUE;
    @Expose
    private  String groupName;
    @Expose
    private  String groupHeader;
    @Expose
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
