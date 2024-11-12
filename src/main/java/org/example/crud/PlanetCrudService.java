package org.example.crud;

import org.example.config.HibernateConfig;
import org.example.models.Planet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class PlanetCrudService {

    private final SessionFactory sessionFactory = HibernateConfig.getInstance().getSessionFactory();

    public void savePlanet(String planetName) {
        Planet planet = new Planet();
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                Planet findedPlanet = session.find(Planet.class, planetName.toUpperCase());
                if (findedPlanet == null) {
                    planet.setId(planetName.toUpperCase());
                    planet.setName(planetName);
                    session.persist(planet);
                } else {
                    System.out.println("Така планета вже існує");
                }
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
            }
        }
    }

    public Planet findById(String id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                Planet planet = session.find(Planet.class, id.toUpperCase());
                transaction.commit();
                return planet;
            } catch (Exception e) {
                transaction.rollback();
            }
        }
        return null;
    }

    public void deleteById(String id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                Planet planet = session.find(Planet.class, id.toUpperCase());
                if (planet != null) {
                    session.createQuery("DELETE FROM Ticket t WHERE t.fromPlanet.id = :planetId OR t.toPlanet.id = :planetId")
                            .setParameter("planetId", planet.getId())
                            .executeUpdate();
                    session.remove(planet);
                    transaction.commit();
                }
            } catch (Exception e) {
                transaction.rollback();
            }
        }
    }

    public void updatePlanet(Planet planet) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                Planet findedPlanet = session.find(planet.getClass(), planet.getId());
                if (findedPlanet != null) {
                    findedPlanet.setName(planet.getName());
                    transaction.commit();
                }
            } catch (Exception e) {
                transaction.rollback();
            }
        }
    }
}
