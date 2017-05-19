package it.promobag.vinnaisimo.Dao;

import it.promobag.vinnaisimo.Dto.ShopOwnerDTO;
import it.promobag.vinnaisimo.Entities.Shop;
import it.promobag.vinnaisimo.Entities.ShopOwner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
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
}
