package it.promobag.vinnaisimo;

import it.promobag.vinnaisimo.Dao.UserDaoImpl;
import it.promobag.vinnaisimo.Dto.UserDTO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

/**
 * Created by vsantucc on 17/05/2017.
 */
@SpringBootApplication
public class Application extends SpringBootServletInitializer{

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        UserDTO udto = new UserDTO();
        udto.setName("Simone");
        udto.setPassword("password");
        udto.setMail("prova");
        UserDaoImpl userDao = new UserDaoImpl();
        userDao.insertUser(udto);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }
}
