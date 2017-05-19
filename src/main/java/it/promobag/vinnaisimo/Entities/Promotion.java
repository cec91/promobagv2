package it.promobag.vinnaisimo.Entities;

import javax.persistence.*;

/**
 * Created by vsantucc on 18/05/2017.
 */
@Entity
@Table(name="owner")
public class Promotion {

    @Id
    @Column(name = "promotion_id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name="shop_id", insertable=false, updatable=false, nullable=false)
    private Shop shop;

    public Promotion() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
