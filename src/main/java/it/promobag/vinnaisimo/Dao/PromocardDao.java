package it.promobag.vinnaisimo.Dao;

import it.promobag.vinnaisimo.Entities.PromoCard;

import java.util.ArrayList;

/**
 * Created by vsantucc on 18/05/2017.
 */
public interface PromocardDao {

    ArrayList<PromoCard> getAllCardOfUser(int id);
    PromoCard getPromoCardByShopId(int id);
}
