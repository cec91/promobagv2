package it.promobag.vinnaisimo.Dto;

import it.promobag.vinnaisimo.Entities.Promotion;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by vsantucc on 18/05/2017.
 */
public class ShopDTO extends BasicDTO {


    private String shopName;

    private Set<Promotion> promotions;

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public Set<Promotion> getPromotions() {
        return promotions;
    }

    public void setPromotions(Set<Promotion> promotions) {
        this.promotions = promotions;
    }
}
