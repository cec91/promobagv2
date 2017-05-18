package it.promobag.vinnaisimo.Dao;

import it.promobag.vinnaisimo.Dto.UserDTO;

/**
 * Created by vsantucc on 17/05/2017.
 */
public interface UserDao {
    String getUserByName(String name);
    void insertUser(UserDTO userR);
}
