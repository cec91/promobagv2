package it.promobag.vinnaisimo.Dao;

import it.promobag.vinnaisimo.Entities.Shop;

/**
 * Created by vsantucc on 18/05/2017.
 */
public interface ShopDao {

    Shop getShopById(int id);
    void updateShop(Shop shopU);

}
