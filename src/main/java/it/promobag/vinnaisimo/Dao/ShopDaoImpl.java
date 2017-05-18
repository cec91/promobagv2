package it.promobag.vinnaisimo.Dao;

import it.promobag.vinnaisimo.Entities.Shop;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by vsantucc on 18/05/2017.
 */
public class ShopDaoImpl implements ShopDao {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
    private EntityManager em = emf.createEntityManager();

    @Override
    public Shop getShopById(int id) {

        Shop shop = new Shop();
        try{
                shop = (Shop) em.createQuery("SELECT s FROM Shop s WHERE s.id =:id").setParameter("id", id).getSingleResult();

        }catch(Exception e){
            e.printStackTrace();
        }

        return shop;
    }

    @Override
    public void updateShop(Shop shopU) {
        em.getTransaction().begin();
        em.merge(shopU);
        em.getTransaction().commit();
        System.out.println("Transaction committed successfully");
    }
}
