package it.promobag.vinnaisimo;

import it.promobag.vinnaisimo.Dao.PromocardDaoImpl;
import it.promobag.vinnaisimo.Dao.ShopDaoImpl;
import it.promobag.vinnaisimo.Dao.ShopOwnerDaoImpl;
import it.promobag.vinnaisimo.Dao.UserDaoImpl;
import it.promobag.vinnaisimo.Dto.PromotionDTO;
import it.promobag.vinnaisimo.Dto.ShopOwnerDTO;
import it.promobag.vinnaisimo.Dto.UserDTO;
import it.promobag.vinnaisimo.Entities.PromoCard;
import it.promobag.vinnaisimo.Entities.Promotion;
import it.promobag.vinnaisimo.Entities.Shop;
import it.promobag.vinnaisimo.Entities.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by vsantucc on 17/05/2017.
 */

@RestController
public class ControllerPromobag {


    //base path /promobag
    @RequestMapping(value="/hello")
    public String sayHello(){
        return "Hello from promobag";
    }

  /*  @RequestMapping(value="/user")
    public String user(){
        UserDaoImpl userDao = new UserDaoImpl();
        String namer = userDao.getUserByName("Vincenzo Santucci");
        System.out.println("il nome preso dal database e: " + namer);
        return namer;

    } */
    //SIGNIN UTENTE FUNZIONANTE
    @RequestMapping(value="/user/signin", method= RequestMethod.POST)
    public HttpStatus siginIn(@RequestBody UserDTO input){
            new UserDaoImpl().insertUser(input);
        //devo restituire id utente
        return HttpStatus.OK;


    }

    //LOGIN LATO UTENTE 
    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    public HttpStatus logIn(@RequestBody UserDTO input){
        UserDaoImpl udi = new UserDaoImpl();
        User us = udi.getUserByMail(input);
        if (us.getPassword().equals(input.getPassword())){

            return HttpStatus.OK;
        }else{

            return HttpStatus.NOT_FOUND;
        }

    }

    //SIGNIN VENDITORE
    @RequestMapping(value="/shopowner/signin", method= RequestMethod.POST)
    public HttpStatus siginInShop(@RequestBody ShopOwnerDTO input){
        new ShopOwnerDaoImpl().insertUser(input);
        //devo restituire id venditore e id negozio
        return HttpStatus.OK;
    }

    //INSERIMENTO DI UNA PROMOZIONE TODO
    @RequestMapping(value = "/shopowner/register/promotion", method = RequestMethod.POST)
    public HttpStatus insertPromotion(@RequestBody PromotionDTO input){
        ShopDaoImpl sdi = new ShopDaoImpl();
        Shop shop = sdi.getShopById(input.getShopId());
        Promotion promo = new Promotion();
        promo.setDescription(input.getDescription());
        ArrayList<Promotion> promotions = new ArrayList<Promotion>(shop.getPromotions());
        promotions.add(promo);
        shop.setPromotions(new HashSet<Promotion>(promotions));
        sdi.updateShop(shop);

        return HttpStatus.OK;
    }



    @RequestMapping(value="/user/promocard/all/{id}", method = RequestMethod.GET)
    public String getAllCardsofUser(@PathVariable(value="id") String id){
        int idU = Integer.valueOf(id);
        PromocardDaoImpl promocardDaoI = new PromocardDaoImpl();
        Set<PromoCard> cards = promocardDaoI.getAllCardOfUser(idU);
        return "";
    }

    @RequestMapping(value="/shopowner/user/all/{shop_id}", method = RequestMethod.GET)
    public String getAllUsersLinked(@PathVariable(value="shop_id") String id){
        int idS = Integer.valueOf(id);
        PromoCard pc = new PromocardDaoImpl().getPromoCardByShopId(idS);
        //qua prendere tutti gli utenti con promocard id


        return "";
    }
}
