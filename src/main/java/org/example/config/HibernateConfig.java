package org.example.config;

import org.example.models.Client;
import org.example.models.Planet;
import org.example.models.Ticket;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConfig {
    private static final HibernateConfig INSTANCE;
    private SessionFactory sessionFactory;
    static {
        INSTANCE = new HibernateConfig();
    }
    public static HibernateConfig getInstance() {
        return INSTANCE;
    }
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    private HibernateConfig(){
        sessionFactory =  new Configuration()
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(Planet.class)
                .addAnnotatedClass(Ticket.class)
                .buildSessionFactory();
    }
}
