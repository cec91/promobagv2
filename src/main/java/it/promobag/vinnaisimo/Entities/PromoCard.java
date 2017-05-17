package it.promobag.vinnaisimo.Entities;

import javax.persistence.*;

/**
 * Created by VSANTUCC on 17/05/2017.
 */
@Entity
@Table(name="promocard")
public class PromoCard {

    @Id
    @Column(name = "card_id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @Column(name = "gift_check")
    private int gift_check;

    @ManyToOne
    @JoinColumn(name="user_id", insertable=false, updatable=false, nullable=false)
    private User user;

    @OneToOne
    @JoinColumn(name = "shop_id")
    private Shop shop;

    public PromoCard() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGift_check() {
        return gift_check;
    }

    public void setGift_check(int gift_check) {
        this.gift_check = gift_check;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
