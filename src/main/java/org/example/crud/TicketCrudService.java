package org.example.crud;

import org.example.config.HibernateConfig;
import org.example.models.Client;
import org.example.models.Planet;
import org.example.models.Ticket;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.time.LocalDateTime;

public class TicketCrudService {
    private final SessionFactory sessionFactory = HibernateConfig.getInstance().getSessionFactory();

    public void createTicket(Ticket ticket) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(ticket);
            transaction.commit();
        }
    }

    public Ticket findTicketById(long id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                Ticket ticket = session.find(Ticket.class, id);
                if (ticket != null) {
                    Hibernate.initialize(ticket.getClient().getTickets());
                    Hibernate.initialize(ticket.getFromPlanet().getFromPlanet());
                    Hibernate.initialize(ticket.getToPlanet().getToPlanet());
                    transaction.commit();
                    return ticket;
                }
            } catch (Exception e) {
                transaction.rollback();
            }
        }
        return null;
    }

    public void deleteTicket(long id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                Ticket ticket = session.find(Ticket.class, id);
                if (ticket != null) {
                    session.remove(ticket);
                    transaction.commit();
                }
            } catch (Exception e) {
                transaction.rollback();
            }
        }
    }

    public void updateTicket(Ticket ticket) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                Ticket findedTicket = session.find(Ticket.class, ticket.getId());
                if (findedTicket != null) {
                    findedTicket.setCreatedAt(ticket.getCreatedAt());
                    findedTicket.setClient(ticket.getClient());
                    findedTicket.setFromPlanet(ticket.getFromPlanet());
                    findedTicket.setToPlanet(ticket.getToPlanet());
                } else {
                    System.out.println("Квиток не існує");
                }
                transaction.commit();
            }catch (Exception e){
                transaction.rollback();
            }
        }
    }
}
