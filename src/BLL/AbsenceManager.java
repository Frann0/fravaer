package BLL;

import BE.Subject;
import BE.User;
import DAL.UserDAL;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class AbsenceManager {
    private UserDAL myUserDAL;
    ObservableList<User> allStudents;

    public AbsenceManager(){
        myUserDAL = new UserDAL();
        allStudents = myUserDAL.getStudents();
    }

    // TODO getStudentAbsence
    public ArrayList<Subject> getStudentAbsence(String username){
        ArrayList<Subject> subjects = null;
        for(User student : allStudents){
            if(student.getUsername().equals(username)){
                subjects = student.getSubjects();
            }
        }
        return subjects;
    }

    // TODO getAllStudentsAbsence
    // Uses getStudentAbsence

    // TODO getSubjectStatistics
    // Uses getAllStudentsAbsence


}
