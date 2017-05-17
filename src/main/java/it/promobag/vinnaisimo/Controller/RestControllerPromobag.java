package it.promobag.vinnaisimo.Controller;

import it.promobag.vinnaisimo.Dao.UserDaoImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by vsantucc on 17/05/2017.
 */

@RestController
public class RestControllerPromobag {

    @RequestMapping(value="/hello/promobag")
    public String sayHello(){
        return "Hello from promobag";
    }

    @RequestMapping("hello")
    public String hello(){
        return "Hello from promobag";
    }

    @RequestMapping(value="/user")
    public String user(){
        UserDaoImpl userDao = new UserDaoImpl();
        String namer = userDao.getUserByName("Vincenzo Santucci");
        System.out.println("il nome preso dal database e: " + namer);
        return namer;

    }
}
