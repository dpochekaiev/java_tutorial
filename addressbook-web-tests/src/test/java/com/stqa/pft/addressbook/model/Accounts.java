package com.stqa.pft.addressbook.model;

import com.google.common.collect.ForwardingSet;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Accounts extends ForwardingSet<AccountMap> {

    private Set<AccountMap> delegate;

    public Accounts(Accounts accounts) {
        this.delegate = new HashSet<AccountMap>(accounts.delegate);
    }

    public Accounts() {
        this.delegate = new HashSet<AccountMap>();
    }

    public Accounts(Collection<AccountMap> accounts) {
        this.delegate = new HashSet<AccountMap>(accounts);
    }

    @Override
    protected Set<AccountMap> delegate() {
        return delegate;
    }

    public Accounts withAdded (AccountMap account) {
        Accounts accounts = new Accounts(this);
        accounts.add(account);
        return accounts;
    }

    public Accounts without (AccountMap account) {
        Accounts accounts = new Accounts(this);
        accounts.remove(account);
        return accounts;
    }

}
