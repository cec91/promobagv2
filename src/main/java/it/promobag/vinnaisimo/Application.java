package it.promobag.vinnaisimo;

import it.promobag.vinnaisimo.Dao.UserDaoImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;

/**
 * Created by vsantucc on 17/05/2017.
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        UserDaoImpl userDao = new UserDaoImpl();
        userDao.insertUser();
    }
}
