package it.promobag.vinnaisimo.Dto;

/**
 * Created by vsantucc on 19/05/2017.
 */
public class PromocardDTO {

    private String shopName;

    private int numeroTimbri;

    private String userMail;


    private int first;

    public PromocardDTO() {
    }



    public int getNumeroTimbri() {
        return numeroTimbri;
    }

    public void setNumeroTimbri(int numeroTimbri) {
        this.numeroTimbri = numeroTimbri;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }
}
