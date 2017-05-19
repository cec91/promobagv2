package it.promobag.vinnaisimo.Entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Set;

/**
 * Created by VSANTUCC on 17/05/2017.
 */
@Entity
@Table(name="shop")
public class Shop {

    @Id
    @Column(name = "shop_id")
    @org.hibernate.annotations.GenericGenerator(name="hilo-strategy", strategy = "hilo")
    @GeneratedValue(generator = "hilo-strategy")
    private int id;


    @Column(name = "shopName")
    private String shopName;

    @OneToMany(cascade={CascadeType.ALL})
    @JoinColumn(name="shop_id")
    private Set<Promotion> promotions;


    @OneToOne(mappedBy = "shop")
    public ShopOwner shopOwner;

    @OneToOne(mappedBy = "shop")
    public PromoCard promoCard;

    public Shop() {
    }

    public Set<Promotion> getPromotions() {
        return promotions;
    }

    public void setPromotions(Set<Promotion> promotions) {
        this.promotions = promotions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public ShopOwner getShopOwner() {
        return shopOwner;
    }

    public void setShopOwner(ShopOwner shopOwner) {
        this.shopOwner = shopOwner;
    }

    public PromoCard getPromoCard() {
        return promoCard;
    }

    public void setPromoCard(PromoCard promoCard) {
        this.promoCard = promoCard;
    }
}
