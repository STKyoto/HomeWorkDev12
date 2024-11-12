package org.example.crud;


import org.example.config.HibernateConfig;
import org.example.models.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ClientCrudService {
    private final SessionFactory sessionFactory = HibernateConfig.getInstance().getSessionFactory();

    public void saveClient(String name) {
        Client client = new Client();
        client.setName(name);
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                session.persist(client);
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
            }
        }
    }

    public Client findById(long id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                Client client = session.find(Client.class, id);
                transaction.commit();
                return client;
            } catch (Exception e) {
                transaction.rollback();
            }
        }
        return null;
    }

    public void deleteById(long id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                Client findedClient = session.find(Client.class, id);
                if (findedClient != null) {
                    session.remove(findedClient);
                    transaction.commit();
                }
            } catch (Exception e) {
                transaction.rollback();
            }
        }
    }

    public void updateClient(Client client) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                Client findedClient = session.find(client.getClass(), client.getId());
                if (findedClient != null) {
                    findedClient.setName(client.getName());
                    transaction.commit();
                }
            } catch (Exception e) {
                transaction.rollback();
            }
        }
    }
}
