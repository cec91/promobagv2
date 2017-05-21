package it.promobag.vinnaisimo.Dto;

/**
 * Created by VSANTUCC on 21/05/2017.
 */
public class UserToShopDTO {

    private String name;

    private String email;

    public UserToShopDTO(String name, String email) {
        this.name = name;
        this.email = email;
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
}
