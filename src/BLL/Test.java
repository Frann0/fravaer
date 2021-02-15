package BLL;

import BE.Subject;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class Test {


    public static void main(String[] args) {
        AbsenceManager ab =  new AbsenceManager();
        ArrayList<Subject> absence = ab.getStudentAbsence("svendh");

        for(Subject sub : absence)
        System.out.println(sub.getName() + " " + sub.getAbsence());

    }
}
