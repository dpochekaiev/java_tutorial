package com.stqa.pft.addressbook.model;

import com.google.common.collect.ForwardingSet;

import java.util.HashSet;
import java.util.Set;

public class Groups extends ForwardingSet<GroupMap> {

    private Set<GroupMap> delegate;

    public Groups(Groups groups) {
        this.delegate = new HashSet<GroupMap>(groups.delegate);
    }

    public Groups() {
        this.delegate = new HashSet<GroupMap>();
    }

    @Override
    protected Set<GroupMap> delegate() {
        return delegate;
    }

    public Groups withAdded(GroupMap group) {
        Groups groups = new Groups(this);
        groups.add(group);
        return groups;
    }

    public Groups without(GroupMap group) {
        Groups groups = new Groups(this);
        groups.remove(group);
        return groups;
    }
}
