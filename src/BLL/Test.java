package BLL;

import BE.Subject;

import java.util.ArrayList;

public class Test {


    public static void main(String[] args) {
        AbsenceManager myAbsenceManager = new AbsenceManager();
        ArrayList<Subject> absence = myAbsenceManager.getStudentAbsence("madsq");

        for(Subject sub : absence){
            System.out.println(sub.getName() + " " + sub.getAbsence());
        }
    }
}
