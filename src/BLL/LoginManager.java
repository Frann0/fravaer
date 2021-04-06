package BLL;

import BE.Lecture;
import BE.Student;
import BE.User;
import BE.UserRole;
import DAL.DB.UserDAL;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class LoginManager {
    private static List<User> debugUsers = new ArrayList<>();
    private static List<Student> debugStudents = new ArrayList<>();

    /**
     * attempt a login with the given credentials.
     * @param username the username of the user
     * @param password the password of the user
     * @return either a user object if successful, or null.
     */
    public User attemptLogin(String username, String password) {
        UserDAL userDAL = new UserDAL();
        for (User u : userDAL.getUsers()){
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
    public User debugAttemptLogin(String username, String password){
        Student dp = new Student(404,UserRole.Student, "dp","test","Dennis","PC");
        Lecture lecture = new Lecture();
        dp.getLectures().add(lecture);
        lecture.setLectureId(76);
        lecture.setDate(LocalDateTime.now().minusHours(1));
        lecture.setLectureDuration(Duration.ofHours(2));
        debugStudents.add(new Student(1, UserRole.Student, "Mikeh","test","Mike","Hovedskov"));
        debugStudents.add(dp);
        debugUsers.add(new User(UserRole.Admin, "Jeppe","test","Jeppe","Led"));
        debugUsers.addAll(debugStudents);

        for (User u : debugUsers){
            if (username.equalsIgnoreCase(u.getUsername()) && password.contains(u.getPassword())){
                return u;
            }
        }
        return null;
    }


    public static List<Student> getDebugStudents() {
        return debugStudents;
    }


    public static List<User> getDebugUsers() {
        return debugUsers;
    }

    //UserDAL myUserDAL = new UserDAL();

    //public List<User> getAllUsers(){
        //return myUserDAL.getAllUsers();
    //}
}
