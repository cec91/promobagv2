package it.promobag.vinnaisimo.Dto;

import it.promobag.vinnaisimo.Entities.PromoCard;

import java.util.ArrayList;

/**
 * Created by VSANTUCC on 20/05/2017.
 */
public class UserCardsDTO {

    private String mail;

    private ArrayList<PromoCard> promocards;

    public UserCardsDTO(String mail, ArrayList<PromoCard> promocards) {
        this.mail = mail;
        this.promocards = promocards;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public ArrayList<PromoCard> getPromocards() {
        return promocards;
    }

    public void setPromocards(ArrayList<PromoCard> promocards) {
        this.promocards = promocards;
    }
}
