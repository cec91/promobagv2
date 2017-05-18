package it.promobag.vinnaisimo;

import it.promobag.vinnaisimo.Dao.PromocardDaoImpl;
import it.promobag.vinnaisimo.Dao.UserDaoImpl;
import it.promobag.vinnaisimo.Dto.UserDTO;
import it.promobag.vinnaisimo.Entities.PromoCard;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    //@PathVariable String userId, @RequestBody Bookmark input
    @RequestMapping(value="/user/signin", method= RequestMethod.POST)
    public void siginIn(@RequestBody UserDTO input){
            new UserDaoImpl().insertUser(input);

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
