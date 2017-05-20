package it.promobag.vinnaisimo.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.promobag.vinnaisimo.Entities.Shop;

import javax.persistence.*;

/**
 * Created by VSANTUCC on 18/05/2017.
 */
@Entity
@Table(name="owner")
public class ShopOwner {

    @Id
    @Column(name = "owner_id")
    @org.hibernate.annotations.GenericGenerator(name="hilo-strategy", strategy = "hilo")
    @GeneratedValue(generator = "hilo-strategy")
    private int ownerId;

    @Column(name = "name")
    private String name;

    @Column(name = "mail")
    private String mail;

    @Column(name = "password")
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "shop_id")
    private Shop shop;

    public ShopOwner() {
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @JsonIgnore
    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }
}