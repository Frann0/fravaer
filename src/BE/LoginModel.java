package BE;

import BE.User;
import BLL.LoginManager;

import java.util.List;

public class LoginModel {
    LoginManager myLoginManager = new LoginManager();

    public List<User> getAllUsers(){
        return myLoginManager.getAllUsers();
    }
}
