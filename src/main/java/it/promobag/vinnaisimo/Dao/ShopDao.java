package it.promobag.vinnaisimo.Dao;

import it.promobag.vinnaisimo.Entities.Shop;

/**
 * Created by vsantucc on 18/05/2017.
 */
public interface ShopDao {

    Shop getShopByName(String name);
    void updateShop(Shop shopU);
    Shop getShopById(int id);

}
