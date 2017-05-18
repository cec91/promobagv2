package it.promobag.vinnaisimo.Dao;

import it.promobag.vinnaisimo.Dto.UserDTO;
import it.promobag.vinnaisimo.Entities.User;

import java.util.ArrayList;
import java.util.Set;

/**
 * Created by vsantucc on 17/05/2017.
 */
public interface UserDao {
    User getUserByMail(UserDTO user);
    void insertUser(UserDTO userR);
    Set<User> getUsersByPromocardId(int id);
}
