package it.promobag.vinnaisimo.Dao;

import it.promobag.vinnaisimo.Dto.PromotionDTO;
import it.promobag.vinnaisimo.Entities.Promotion;
import it.promobag.vinnaisimo.Entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;

/**
 * Created by VSANTUCC on 20/05/2017.
 */
public class PromotionDaoImpl implements PromotionDao{

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
    private EntityManager em = emf.createEntityManager();

    @Override
    public ArrayList<Promotion> getAllPromotion() {

        ArrayList<Promotion> promotions = new ArrayList<Promotion>();

        try {

            promotions.addAll(em.createQuery("SELECT p FROM Promotion p").getResultList());

        }catch(Exception e){
            System.out.println("Errore durante il retrieve delle promotions");
            e.printStackTrace();
            return null;
        }

        return promotions;
    }
}
