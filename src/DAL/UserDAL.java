package DAL;

import BE.Subject;
import BE.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class UserDAL {
    private final String dbHost = "127.0.0.1";
    private final String dbPort = "3306";
    private final String dbUser = "root";
    private final String dbPass = "root";

    ObservableList<User> allUsers;

    public UserDAL() {
        //DO DB CONNECTION
        allUsers = loadUsers();
        loadSubjects();
    }


    public ObservableList<User> getStudents(){
        ObservableList<User> allStudents = FXCollections.observableArrayList();
        for(User user : allUsers){
            if(user.getRole() == 1){
                allStudents.add(user);
            }
        }
        return allStudents;
    }

    public ObservableList<User> getTeachers(){
        ObservableList<User> allTeachers = FXCollections.observableArrayList();
        for(User user : allUsers){
            if(user.getRole() == 2){
                allTeachers.add(user);
            }
        }
        return allTeachers;
    }

    public ObservableList<User> loadUsers() {
        ObservableList<User> allUsers = FXCollections.observableArrayList();
        //Users 1,2,3,4 - student
        User s1 = new User(1,"madsq","test","Mads","Qvistgaard");
        s1.setId(1);
        allUsers.add(s1);
        User s2 = new User(1,"svendh","test","Svend","Halding");
        s2.setId(2);
        allUsers.add(s2);
        User s3 = new User(1,"jonasb","test","Jonas","Buus");
        s3.setId(3);
        allUsers.add(s3);
        User s4 = new User(1,"mikeh","test","Mike","Hovedskov");
        s4.setId(4);
        allUsers.add(s4);

        //Teachers
        User t1 = new User(2,"peters","test","Peter","Stegger");
        t1.setId(5);
        allUsers.add(t1);
        User t2 = new User(2,"jeppe","test","Jeppe","Deromkring");
        t2.setId(6);
        allUsers.add(t2);

        return allUsers;
    }

    public void loadSubjects(){
        for(User student : this.allUsers){
            if(student.getRole() == 1){
                assignSubjectsToStudent(student);
            }
        }
    }

    public void assignSubjectsToStudent(User student){
        Subject SCO = new Subject("SCO");
        Subject SDE = new Subject("SDE");
        Subject DBO = new Subject("DBO");
        Subject ITO = new Subject("ITO");
        student.addSubject(SCO);
        student.addSubject(SDE);
        student.addSubject(DBO);
        student.addSubject(ITO);
    }
}
