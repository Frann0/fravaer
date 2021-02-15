package BLL;

import BE.Subject;
import BE.User;
import DAL.UserDAL;

import java.util.List;

public class AbsenceManager {
    private UserDAL myUserDAL;
    List<User> allStudents;

    public AbsenceManager(){
        myUserDAL = new UserDAL();
        allStudents = myUserDAL.getStudents();
    }


    public List<User> getStudents(){
        return myUserDAL.getStudents();

    }


    // TODO getSubjectAttendance
    public List<Subject> getSubjectAttendance(){
        return myUserDAL.getSubjectAbsence();
    }



    public static void main(String[] args) {
        AbsenceManager absm = new AbsenceManager();

        List<User> students = absm.getStudents();

        for(User user : students){
            List<Subject> attendance = user.getSubjects();
            for(Subject sub : attendance){
                System.out.println(user.getFirstName() + " " + sub.getName() + " attendance:");
                System.out.println(sub.getAbsence());

            }
            System.out.println("Total absence: " + user.getTotalAbsence());
        }
    }
}

