package it.promobag.vinnaisimo.Dao;

/**
 * Created by vsantucc on 17/05/2017.
 */
public interface UserDao {
    String getUserByName(String name);
    void insertUser();
}
