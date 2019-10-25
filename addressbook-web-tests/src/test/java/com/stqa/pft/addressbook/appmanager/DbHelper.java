package com.stqa.pft.addressbook.appmanager;

import com.stqa.pft.addressbook.model.AccountMap;
import com.stqa.pft.addressbook.model.Accounts;
import com.stqa.pft.addressbook.model.GroupMap;
import com.stqa.pft.addressbook.model.Groups;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class DbHelper {

    private final SessionFactory sessionFactory;

    public DbHelper() {
        // A SessionFactory is set up once for an application!
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
    }

    public Groups groups() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        List<GroupMap> result = session.createQuery( "from GroupMap" ).list();

        session.getTransaction().commit();
        session.close();
        return new Groups(result);
    }

    public Accounts accounts() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        List<AccountMap>  result = session.createQuery( "from AccountMap where deprecated = '0'" ).list();

        session.getTransaction().commit();
        session.close();
        return new Accounts(result);
    }

}
