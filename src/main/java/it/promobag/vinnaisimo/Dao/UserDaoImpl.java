package it.promobag.vinnaisimo.Dao;

import it.promobag.vinnaisimo.Dto.UserDTO;
import it.promobag.vinnaisimo.Entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


/**
 * Created by vsantucc on 17/05/2017.
 */
public class UserDaoImpl implements UserDao {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
    private EntityManager em = emf.createEntityManager();

    @Override
    public User getUserByMail(UserDTO user) {

        User us = new User();
        try{
            us = (User) em.createQuery("SELECT u FROM User u WHERE u.mail =:mail").setParameter("mail", user.getMail()).getSingleResult();

        }catch(Exception e){
            e.printStackTrace();
        }

        return us;
    }

    public Set<User> getUsersByPromocardId(int id){

        ArrayList<User> users = new ArrayList<User>();
        try{
            users = (ArrayList<User>) em.createQuery("SELECT u FROM User u WHERE u.name =:name").setParameter("promocardid", id).getResultList();
        }catch(Exception e){
            e.printStackTrace();
        }
        Set<User> usersSet = new HashSet<User>(users);
        return usersSet;
    }

    @Override
    public void insertUser(UserDTO userR) {
        User user = new User();
        user.setName(userR.getName());
        user.setEmail(userR.getMail());
        user.setPassword(userR.getPassword());
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        System.out.println("Transaction committed successfully");
        try {
            User us = (User) em.createQuery("SELECT u FROM User u WHERE u.name =:name").setParameter("name", userR.getName()).getSingleResult();
            System.out.println("Name retrieved is: " + us.getName());
        }catch(NonUniqueResultException e){
            e.printStackTrace();
            ArrayList<User>  retrieved = (ArrayList<User>) em.createQuery("SELECT u FROM User u WHERE u.name =:name").setParameter("name", userR.getName()).getResultList();
          for(User u : retrieved){
              System.out.println("Name retrieved is: " + u.getName());
          }
        }
    }
}
