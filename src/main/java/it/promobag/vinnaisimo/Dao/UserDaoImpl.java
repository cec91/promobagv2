package it.promobag.vinnaisimo.Dao;

import it.promobag.vinnaisimo.Entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


/**
 * Created by vsantucc on 17/05/2017.
 */
public class UserDaoImpl implements UserDao {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
    private EntityManager em = emf.createEntityManager();

    @Override
    public String getUserByName(String name) {
        User us = (User) em.createQuery("SELECT u FROM User u WHERE u.name =:name").setParameter("name", name).getSingleResult();
        return us.getName();
    }

    @Override
    public void insertUser() {
        User user = new User();
        user.setName("Vincenzo Santucci");
        user.setEmail("vincenzo.santucci1@gmail.com");
        user.setPassword("password");
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        System.out.println("Transaction committed successfully");

        User us = (User) em.createQuery("SELECT u FROM User u WHERE u.name =:name").setParameter("name", "Vincenzo Santucci").getSingleResult();
        System.out.println("Name retrieved is: " + us.getName());
    }
}
