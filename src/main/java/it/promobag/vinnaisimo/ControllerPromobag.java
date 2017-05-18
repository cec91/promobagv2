package it.promobag.vinnaisimo;

import it.promobag.vinnaisimo.Dao.PromocardDaoImpl;
import it.promobag.vinnaisimo.Dao.ShopOwnerDaoImpl;
import it.promobag.vinnaisimo.Dao.UserDaoImpl;
import it.promobag.vinnaisimo.Dto.ShopOwnerDTO;
import it.promobag.vinnaisimo.Dto.UserDTO;
import it.promobag.vinnaisimo.Entities.PromoCard;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value="/user")
    public String user(){
        UserDaoImpl userDao = new UserDaoImpl();
        String namer = userDao.getUserByName("Vincenzo Santucci");
        System.out.println("il nome preso dal database e: " + namer);
        return namer;

    }
    //SIGNIN UTENTE FUNZIONANTE
    @RequestMapping(value="/user/signin", method= RequestMethod.POST)
    public HttpStatus siginIn(@RequestBody UserDTO input){
            new UserDaoImpl().insertUser(input);
        return HttpStatus.OK;


    }
    //SIGNIN VENDITORE
    @RequestMapping(value="/shopowner/signin", method= RequestMethod.POST)
    public HttpStatus siginInShop(@RequestBody ShopOwnerDTO input){
        new ShopOwnerDaoImpl().insertUser(input);
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
