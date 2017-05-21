package it.promobag.vinnaisimo.Dao;

import it.promobag.vinnaisimo.Dto.UserDTO;
import it.promobag.vinnaisimo.Entities.User;

import javax.persistence.*;
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
    public User getUserByMail(String mail) {

        User us = new User();
        try{
            us = (User) em.createQuery("SELECT u FROM User u WHERE u.email =:email").setParameter("email", mail).getSingleResult();

        }catch(NoResultException e){

            e.printStackTrace();
            return null;
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
    public ArrayList<User> getAllUsers() {

        ArrayList<User> users = new ArrayList<User>();
        try{
            users = (ArrayList<User>) em.createQuery("SELECT u FROM User u").getResultList();
        }catch(Exception e){

            e.printStackTrace();
        }


        return users;
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

    @Override
    public void updateUser(User us) {
        em.getTransaction().begin();
        em.merge(us);
        em.getTransaction().commit();
        System.out.println("Transaction committed successfully");
    }
}
