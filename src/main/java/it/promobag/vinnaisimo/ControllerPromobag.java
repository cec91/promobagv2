package it.promobag.vinnaisimo;

import it.promobag.vinnaisimo.Dao.ShopDaoImpl;
import it.promobag.vinnaisimo.Dao.ShopOwnerDaoImpl;
import it.promobag.vinnaisimo.Dao.UserDaoImpl;
import it.promobag.vinnaisimo.Dto.*;
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


    //SIGNIN UTENTE FUNZIONANTE
    @RequestMapping(value="/user/signin", method= RequestMethod.POST)
    public HttpStatus siginIn(@RequestBody UserDTO input){
        UserDaoImpl usdi = new UserDaoImpl();
            new UserDaoImpl().insertUser(input);
        //devo restituire id utente
        return HttpStatus.OK;



    }

    //LOGIN LATO UTENTE FUNZIONANTE
    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    public HttpStatus logIn(@RequestBody UserDTO input){
        UserDaoImpl udi = new UserDaoImpl();
        User us = udi.getUserByMail(input.getMail());
        if(us != null){
            if (us.getPassword().equals(input.getPassword())){

                return HttpStatus.OK;
            }else{

                return HttpStatus.NOT_FOUND;
            }
        }else{

            return HttpStatus.NOT_FOUND;
        }


    }

    //SIGNIN VENDITORE FUNZIONANTE
    @RequestMapping(value="/shopowner/signin", method= RequestMethod.POST)
    public HttpStatus siginInShop(@RequestBody ShopOwnerDTO input){
        new ShopOwnerDaoImpl().insertUser(input);
        //devo restituire id venditore e id negozio
        return HttpStatus.OK;
    }



    //INSERIMENTO DI UNA PROMOZIONE FUNZIONANTE
    @RequestMapping(value = "/shopowner/register/promotion", method = RequestMethod.POST)
    public HttpStatus insertPromotion(@RequestBody PromotionDTO input){
        ShopDaoImpl sdi = new ShopDaoImpl();
        Shop shop = sdi.getShopByName(input.getShopName());
        System.out.println("Retrieved shop: " + shop.getShopOwner().getName());
        Promotion promo = new Promotion();
        promo.setTitle(input.getTitle());
        promo.setDescription(input.getDescription());
        ArrayList<Promotion> promotions = new ArrayList<Promotion>(shop.getPromotions());
        promotions.add(promo);
        shop.setPromotions(new HashSet<Promotion>(promotions));
        sdi.updateShop(shop);

        return HttpStatus.OK;
    }



    //INSERIMENTO AGGIORNAMENTO DI UNA PROMOCARD
    @RequestMapping(value = "/user/promocard", method = RequestMethod.POST)
    public HttpStatus insertOrUpdatePromocard(@RequestBody PromocardDTO input){

        System.out.println(input.toString());

        if (input.isFirst()){
            System.out.println("Prima promocard");
            User us = new UserDaoImpl().getUserByMail(input.getUserMail());
            Shop shop = new ShopDaoImpl().getShopByName(input.getShopName());
            PromoCard pc = new PromoCard();
            pc.setUser(us);
            pc.setGift_check(input.getNumeroTimbri());
            pc.setShop(shop);


            ArrayList<PromoCard> pcards = new ArrayList<PromoCard>();
            pcards.add(pc);
            //////////////////
            for (PromoCard promoCard : pcards){
                System.out.println("Stampo promocard : " + promoCard.getShop().getShopOwner() + " " + promoCard.getUser().getName());
            }
            //////////////////
            us.setCards(new HashSet<PromoCard>(pcards));

            new UserDaoImpl().updateUser(us);


        }else{
            System.out.println("Promocard esistente");
            //prendo sempre l'utente
            User us = new UserDaoImpl().getUserByMail(input.getUserMail());
            Set<PromoCard> pcs = us.getCards();
            for (PromoCard pc : pcs){

                if (pc.getShop().getShopName().equals(input.getShopName())){
                    pc.setGift_check(pc.getGift_check() + input.getNumeroTimbri());
                }
            }
            us.setCards(pcs);
            new UserDaoImpl().updateUser(us);
            //
         /*   PromoCard pc = new PromocardDaoImpl().getPromoCardByShopId(input.getShopId());
            pc.setGift_check(pc.getGift_check() + input.getNumeroTimbri());
            */

        }

        return HttpStatus.OK;
    }


    /////////////////////////////////**************FUNZIONANTI*********************////////////////////////////////////////

    ////TODO DA TESTARE
    @RequestMapping(value="/user/promocard/all/{user_mail}", method = RequestMethod.GET)
    public UserCardsDTO getAllCardsofUser(@PathVariable(value="user_mail") String user_mail){


        Set<PromoCard> cards = new UserDaoImpl().getUserByMail(user_mail + ".com").getCards();

        return new UserCardsDTO(user_mail, new ArrayList<PromoCard>(cards));
    }

    //////TODO VA FATTA CON SHOPNAME
    @RequestMapping(value="/shopowner/user/all/{shop_name}", method = RequestMethod.GET)
    public String getAllUsersLinked(@PathVariable(value="shop_name") String shop_name){


      //  PromoCard pc = new PromocardDaoImpl().getPromoCardByShopId(idS);
        //qua prendere tutti gli utenti con promocard id


        return "";
    }
}
