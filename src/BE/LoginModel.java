<<<<<<< HEAD:src/GUI/MODEL/LoginModel.java
package GUI.MODEL;
=======
package BE;
>>>>>>> pr/1:src/BE/LoginModel.java

import BE.User;
import BLL.LoginManager;

import java.util.List;

public class LoginModel {
    LoginManager myLoginManager = new LoginManager();

    public List<User> getAllUsers(){
        return myLoginManager.getAllUsers();
    }
}
