package BLL;

import BE.User;
import DAL.UserDAL;

import java.util.List;

public class LoginManager {
    UserDAL myUserDAL = new UserDAL();

    public List<User> getAllUsers(){
        return myUserDAL.getAllUsers();
    }
}
