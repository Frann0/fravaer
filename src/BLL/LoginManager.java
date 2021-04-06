package BLL;

import BE.Student;
import BE.User;
import BE.UserRole;
import DAL.UserDAL;

import java.util.ArrayList;
import java.util.List;

public class LoginManager {

    /**
     * attempt a login with the given credentials.
     * @param username the username of the user
     * @param password the password of the user
     * @return either a user object if successful, or null.
     */
    public User attemptLogin(String username, String password) {
        UserDAL userDAL = new UserDAL();
        for (User u : userDAL.getAllUsers()){
            if (username.equalsIgnoreCase(u.getUsername()) && password.contains(u.getPassword())){
                return u;
            }
        }
        return null;
    }

    /**
     * TODO: NÅR DB ER POPULATED SKIFT TIL ANDEN.
     * @param username
     * @param password
     * @return
     */
    public Student debugAttemptLogin(String username, String password){
        List<Student> debugUsers = new ArrayList<>();
        debugUsers.add(new Student(0,UserRole.Student, "Mikeh","test","Mike","Hovedskov"));
        debugUsers.add(new Student(1,UserRole.Admin, "Jeppe","test","Jeppe","Led"));

        for (Student u : debugUsers){
            if (username.equalsIgnoreCase(u.getUsername()) && password.contains(u.getPassword())){
                return u;
            }
        }
        return null;
    }

    //UserDAL myUserDAL = new UserDAL();

    //public List<User> getAllUsers(){
        //return myUserDAL.getAllUsers();
    //}
}
