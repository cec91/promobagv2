package it.promobag.vinnaisimo.Dto;

import it.promobag.vinnaisimo.Entities.Promotion;

import java.util.ArrayList;

/**
 * Created by VSANTUCC on 20/05/2017.
 */
public class AllPromotionDTO {

    private ArrayList<Promotion> promotions;

    public AllPromotionDTO(ArrayList<Promotion> promotions) {
        this.promotions = promotions;
    }

    public ArrayList<Promotion> getPromotions() {
        return promotions;
    }

    public void setPromotions(ArrayList<Promotion> promotions) {
        this.promotions = promotions;
    }
}
