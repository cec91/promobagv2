package it.promobag.vinnaisimo.Dao;

import it.promobag.vinnaisimo.Dto.ShopOwnerDTO;
import it.promobag.vinnaisimo.Dto.UserDTO;
import it.promobag.vinnaisimo.Entities.ShopOwner;

/**
 * Created by vsantucc on 18/05/2017.
 */
public interface ShopOwnerDao {

    void insertUser(ShopOwnerDTO userO);
    ShopOwner getShopOwnerByMail(String mail);
}
