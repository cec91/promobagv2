package it.promobag.vinnaisimo.Entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Set;

/**
 * Created by vsantucc on 17/05/2017.
 */

@Entity
@Table(name="user")
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int userId;

    @Column(name="name")
    private String name;

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    @OneToMany(cascade={CascadeType.ALL})
    @JoinColumn(name="user_id")
    private Set<PromoCard> cards;


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<PromoCard> getCards() {
        return cards;
    }

    public void setCards(Set<PromoCard> cards) {
        this.cards = cards;
    }
}