package it.promobag.vinnaisimo.Dao;

import it.promobag.vinnaisimo.Dto.ShopOwnerDTO;
import it.promobag.vinnaisimo.Entities.Shop;
import it.promobag.vinnaisimo.Entities.ShopOwner;
import it.promobag.vinnaisimo.Entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;

/**
 * Created by vsantucc on 18/05/2017.
 */
public class ShopOwnerDaoImpl implements ShopOwnerDao{

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
    private EntityManager em = emf.createEntityManager();

    @Override
    public void insertUser(ShopOwnerDTO ownerDTO ) {
        ShopOwner so = new ShopOwner();
        Shop shop = new Shop();

        so.setName(ownerDTO.getName());
        so.setMail(ownerDTO.getMail());
        so.setPassword(ownerDTO.getPassword());
        System.out.println("vado a salvare lo shop owner");
        shop.setShopName(ownerDTO.getShop_name());
        so.setShop(shop);
        System.out.println("Dio ladro: " + so.getShop().getShopName());
        em.getTransaction().begin();
        em.persist(so);
        em.getTransaction().commit();
        System.out.println("Transaction committed successfully");

    }

    @Override
    public ShopOwner getShopOwnerByMail(String mail) {

        System.out.println("Stampo la mail: " + mail);
        ShopOwner so = new ShopOwner();

        try{
            so = (ShopOwner) em.createQuery("SELECT o FROM ShopOwner o WHERE o.mail =:mail").setParameter("mail", mail).getSingleResult();

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

        return so;
    }
}
