package it.promobag.vinnaisimo.Dto;

import it.promobag.vinnaisimo.Entities.Promotion;

import java.util.ArrayList;

/**
 * Created by VSANTUCC on 20/05/2017.
 */
public class AllPromotionDTO {

    private Promotion promotions;
    private String shopName;

    public AllPromotionDTO(Promotion promotions, String shopName) {
        this.promotions = promotions;
        this.shopName = shopName;
    }

    public Promotion getPromotions() {
        return promotions;
    }

    public void setPromotions(Promotion promotions) {
        this.promotions = promotions;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }
}
