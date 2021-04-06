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
    private static final List<User> debugUsers = new ArrayList<>();
    private static final List<Student> debugStudents = new ArrayList<>();
    private static Student currentStudent;
    private static User currentUser;

    /**
     * Loops through the users to see if there is a match on username and password
     * Updates the user if there is user a where username and password is correct
     * Updates the student if there is a Student where username and password is correct
     *
     * @param username the username of the user
     * @param password the password of the user
     */
    public void attemptLogin(String username, String password) {
        UserDAL userDAL = new UserDAL();
        for (User u : userDAL.getUsers()) {
            if (username.equalsIgnoreCase(u.getUsername()) && password.contains(u.getPassword())) {
                for (Student s : userDAL.getStudents()) {
                    if (u.getId() == s.getId())
                        currentStudent = s;
                }
                currentUser=u;
                break;
            }
        }
    }

    /**
     * TODO: NÅR DB ER POPULATED SKIFT TIL ANDEN.
     * Loops through the users to see if there is a match on username and password
     * Updates the user if there is user a where username and password is correct
     * Updates the student if there is a Student where username and password is correct
     *
     * @param username the username try
     * @param password the password try
     */
    public void debugAttemptLogin(String username, String password) {
        Student dp = new Student(404, UserRole.Student, "dp", "test", "Dennis", "PC");
        Lecture lecture = new Lecture();
        dp.getLectures().add(lecture);
        lecture.setLectureId(76);
        lecture.setDate(LocalDateTime.now().minusHours(1));
        lecture.setLectureDuration(Duration.ofHours(2));
        debugStudents.add(new Student(1, UserRole.Student, "Mikeh", "test", "Mike", "Hovedskov"));
        debugStudents.add(dp);
        debugUsers.add(new User(UserRole.Admin, "Jeppe", "test", "Jeppe", "Led"));
        debugUsers.addAll(debugStudents);

        //Attempts to login given the username and password, on success it changes currentUser and currentStudent to the current student
        for (User u : debugUsers) {
            if (username.equalsIgnoreCase(u.getUsername()) && password.equals(u.getPassword())) {
                if (u.getRole() == UserRole.Student)
                    debugStudents.forEach(s -> {
                        if (u.getId() == s.getId())
                            currentStudent = s;
                    });
                currentUser = u;
                break;
            }
        }
    }


    public static List<Student> getDebugStudents() {
        return debugStudents;
    }


    public static List<User> getDebugUsers() {
        return debugUsers;
    }

    public static Student getCurrentStudent() {
        return currentStudent;
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    //UserDAL myUserDAL = new UserDAL();

    //public List<User> getAllUsers(){
    //return myUserDAL.getAllUsers();
    //}
}
