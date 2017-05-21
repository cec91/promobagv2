package it.promobag.vinnaisimo;

import it.promobag.vinnaisimo.Dao.PromotionDaoImpl;
import it.promobag.vinnaisimo.Dao.ShopDaoImpl;
import it.promobag.vinnaisimo.Dao.ShopOwnerDaoImpl;
import it.promobag.vinnaisimo.Dao.UserDaoImpl;
import it.promobag.vinnaisimo.Dto.*;
import it.promobag.vinnaisimo.Entities.*;
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
        return HttpStatus.OK;



    }

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


    @RequestMapping(value="/shopowner/signin", method= RequestMethod.POST)
    public HttpStatus siginInShop(@RequestBody ShopOwnerDTO input){
        new ShopOwnerDaoImpl().insertUser(input);
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

        System.out.println("FISRT: " + input.getFirst());

        if (input.getFirst() == 1){
            System.out.println("Prima promocard");
            User us = new UserDaoImpl().getUserByMail(input.getUserMail());
            Shop shop = new ShopDaoImpl().getShopByName(input.getShopName());
            PromoCard pc = new PromoCard();
            pc.setUser(us);
            pc.setGift_check(input.getNumeroTimbri());
            pc.setShop(shop);


            ArrayList<PromoCard> pcards = new ArrayList<PromoCard>();
            Set<PromoCard> pcs1 = us.getCards();

            if (pcs1 == null || pcs1.size() == 0){

                //bisogna creare l'arraylist e metterci la promocard
                pcards = new ArrayList<PromoCard>();

            }else{
                //bisogna trasformarlo in arraylist e inserire la promocard
                pcards.addAll(us.getCards());

            }
            pcards.add(pc);


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


        }

        return HttpStatus.OK;
    }

    @RequestMapping(value="/user/promocard/all/{user_mail}", method = RequestMethod.GET)
    public UserCardsDTO getAllCardsofUser(@PathVariable(value="user_mail") String user_mail){


        Set<PromoCard> cards = new UserDaoImpl().getUserByMail(user_mail + ".com").getCards();

        return new UserCardsDTO(user_mail, new ArrayList<PromoCard>(cards));
    }


    ///
    @RequestMapping(value="/user/all/promotions/", method = RequestMethod.GET)
    public ArrayList<AllPromotionDTO> getAllPromotions(){
        ArrayList<Promotion> promotions =  new PromotionDaoImpl().getAllPromotion();
        ArrayList<AllPromotionDTO> allPromotionDTOs = new ArrayList<AllPromotionDTO>();
        for (Promotion pro : promotions){

            allPromotionDTOs.add(new AllPromotionDTO(pro,pro.getShop().getShopName()));
        }
        return allPromotionDTOs;
    }

    @RequestMapping(value = "/shopowner/login", method = RequestMethod.POST)
    public HttpStatus shopOwnerLogin(@RequestBody ShopOwnerDTO input){

        System.out.println("stampo oggetto" + input.getPassword()+ " " + input.getName()+ " " + input.getMail()+ " " + input.getPassword()+ " " + input.getShop_name());
        ShopOwner so = new ShopOwnerDaoImpl().getShopOwnerByMail(input.getMail());
        if (so != null && so.getPassword().equals(input.getPassword())){
            return HttpStatus.OK;
        }else{

            return HttpStatus.NOT_FOUND;
        }


    }

    /////////////////////////////////**************FUNZIONANTI*********************////////////////////////////////////////



    //////TODO levare il jsonignore da promotion (get shop) e rivedere l'output mandando no una lista di user ma un altra
    @RequestMapping(value="/shopowner/user/all/{shopName}", method = RequestMethod.GET)
    public ArrayList<UserToShopDTO> getAllUsersLinked(@PathVariable(value="shopName") String shopName){

            ArrayList<UserToShopDTO> toReturn = new ArrayList<UserToShopDTO>();
            ArrayList<User> users = new UserDaoImpl().getAllUsers();
            ArrayList<PromoCard> promoCards = new ArrayList<PromoCard>();
            for (User u : users){
                promoCards.addAll(u.getCards());
                for (PromoCard pc : promoCards) {
                    if(pc.getShop().getShopName().equals(shopName)){
                        toReturn.add(new UserToShopDTO(u.getName(),u.getEmail()));
                    }
                }

            }

        return toReturn;
    }

        //capire perche mail null



}
