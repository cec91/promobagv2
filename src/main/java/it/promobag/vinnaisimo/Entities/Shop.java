package it.promobag.vinnaisimo.Entities;

import javax.persistence.*;

/**
 * Created by VSANTUCC on 17/05/2017.
 */
@Entity
@Table(name="shop")
public class Shop {

    @Id
    @Column(name = "shop_id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @Column(name = "shop_name")
    private String shopName;

    @OneToOne
    @JoinColumn(name = "owner_id")
    private ShopOwner owner;

    public Shop() {
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

    public ShopOwner getOwner() {
        return owner;
    }

    public void setOwner(ShopOwner owner) {
        this.owner = owner;
    }
}
