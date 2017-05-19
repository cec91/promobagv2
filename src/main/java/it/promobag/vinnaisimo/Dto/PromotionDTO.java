package it.promobag.vinnaisimo.Dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by vsantucc on 18/05/2017.
 */
public class PromotionDTO extends BasicDTO{

    private String shopName;

    private String title;

    private int shopId;

    private String description;

    public int getShopId() {
        return shopId;
    }

    public String getTitle() {
        return title;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
