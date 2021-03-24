package DAL;

import BE.Attendance;
import BE.Subject;
import BE.User;
import BE.UserRole;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UserDAL {
    private final String dbHost = "127.0.0.1";
    private final String dbPort = "3306";
    private final String dbUser = "root";
    private final String dbPass = "root";

    List<User> allUsers;
    List<Subject> subjectAbsence;

    public UserDAL() {
        //DO DB CONNECTION
        subjectAbsence = new ArrayList<>();
        allUsers = loadUsers();
        loadSubjects();
        setMostAbsentDay();
        setAbsentDays();
        setSubjectAbsence();
    }

    private void setSubjectAbsence() {
    }

    public List<User> getAllUsers() {
        return allUsers;
    }

    public List<Subject> getSubjectAbsence() {
        return subjectAbsence;
    }

    public List<User> getStudents(){

        List<User> allStudents = new ArrayList<>();
        for(User user : allUsers){
            if(user.getRole() == UserRole.Student){
                allStudents.add(user);
            }
        }
        return allStudents;
    }

    public List<User> getTeachers(){
        ObservableList<User> allTeachers = FXCollections.observableArrayList();
        for(User user : allUsers){
            if(user.getRole() == UserRole.Admin){
                allTeachers.add(user);
            }
        }
        return allTeachers;
    }

    public List<User> loadUsers() {
        List<User> allUsers = new ArrayList<>();
/*
        Subject s1 = new Subject("ITO");
        Subject s2 = new Subject("SCO");
        Subject s3 = new Subject("DBOS");
        List<Subject> userSubjects = new ArrayList<>();
        userSubjects.add(s1);
        userSubjects.add(s2);
        userSubjects.add(s3);


        s3.getSubjectTimes().put(LocalDateTime.now().minusHours(2),LocalDateTime.now().plusHours(2));
        s2.getSubjectTimes().put(LocalDateTime.now().minusHours(2).plusDays(1),LocalDateTime.now().plusHours(2).plusDays(1));

        s1.getSubjectTimes().put(LocalDateTime.now().minusHours(2).plusDays(2),LocalDateTime.now().plusHours(2).plusDays(2));
        s2.getSubjectTimes().put(LocalDateTime.now().minusHours(2).plusDays(3),LocalDateTime.now().plusHours(2).plusDays(3));

        User testUser1= new User(0, UserRole.Student,"Dennis","test","D","P", new ArrayList<>(), userSubjects);
        User testUser2= new User(1, UserRole.Student,"Carlo","test","C","De Leon", new ArrayList<>(), userSubjects);


        testUser1.getAttendance().add(new Attendance(testUser1));
        testUser2.getAttendance().add(new Attendance(testUser2,LocalDateTime.now().minusHours(1).plusDays(1)));
        testUser2.getAttendance().add(new Attendance(testUser2,LocalDateTime.now().minusHours(1).plusDays(3)));
        testUser1.getAttendance().add(new Attendance(testUser1,LocalDateTime.now().minusHours(1).plusDays(2)));


        //Users 1,2,3,4 - student
        User s5 = new User(3,UserRole.Student,"madsq","test","Mads","Qvistgaard", new ArrayList<>(), userSubjects);

        User s6 = new User(4,UserRole.Student,"svendh","test","Svend","Halding", new ArrayList<>(), userSubjects);

        User s7 = new User(5,UserRole.Student,"jonasb","test","Jonas","Buus", new ArrayList<>(), userSubjects);

        User s8 = new User(6,UserRole.Student,"mikeh","test","Mike","Hovedskov", new ArrayList<>(), userSubjects);

        allUsers.add(testUser1);
        allUsers.add(testUser2);
        allUsers.add(s5);
        allUsers.add(s6);
        allUsers.add(s7);
        allUsers.add(s8);

        //Teachers
        User t1 = new User(UserRole.Admin,"peters","test","Peter","Stegger");
        t1.setId(5);
        allUsers.add(t1);
        User t2 = new User(UserRole.Admin,"jeppe","test","Jeppe","Deromkring");
        t2.setId(6);
        allUsers.add(t2);


 */
        return allUsers;
    }

    public void loadSubjects(){
        for(User student : this.allUsers){
            //if(student.getRole() == 1){
                assignSubjectsToStudent(student);
            //}
        }
    }

    public void assignSubjectsToStudent(User student){
    }

    public void setMostAbsentDay(){
    }

    public void setAbsentDays(){
        for(User student : this.allUsers){
            if(student.getRole() == UserRole.Student){
                assignAbsentDays(student);
            }
        }
    }

    private void assignAbsentDays(User student) {
    }
}
