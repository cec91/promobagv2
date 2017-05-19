package it.promobag.vinnaisimo.Dao;

import it.promobag.vinnaisimo.Entities.PromoCard;
import it.promobag.vinnaisimo.Entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.Set;

/**
 * Created by vsantucc on 18/05/2017.
 */
public class PromocardDaoImpl implements PromocardDao {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
    private EntityManager em = emf.createEntityManager();

    @Override
    public Set<PromoCard> getAllCardOfUser(String mail) {
        User us = new User();

        try{
            us = (User) em.createQuery("SELECT u FROM User u WHERE u.email =:email").setParameter("email", mail).getSingleResult();

        }catch(Exception e){
            e.printStackTrace();
        }
        return us.getCards();


    }

    @Override
    public PromoCard getPromoCardByShopId(int id) {
        PromoCard pc = new PromoCard();

        try{
            pc = (PromoCard) em.createQuery("SELECT pc FROM PromoCard pc WHERE pc.shop_id =:id").setParameter("id",id).getSingleResult();

        }catch(Exception e){
            e.printStackTrace();
        }
        return pc;
    }
}
