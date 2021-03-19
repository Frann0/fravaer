package BE;

import BLL.AbsenceManager;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AbsenceModel {
    AbsenceManager myAbsenceManager = new AbsenceManager();

    // todo getAbsentDays
    // creates a list with absentDays fra student + mock subject


    // todo weekDayAbsence
    public List<AbsentDay> getAbsentDaysList(){
        List<AbsentDay> absentDays = new ArrayList<>();
        for (int i = 1; i < 28; i += 3){
            AbsentDay day = new AbsentDay();
            day.setDate((LocalDate.of(2021, 3, i)));
            day.setSubject(randomSubject());
            absentDays.add(day);
        }
        return absentDays;
    }

    private String randomSubject() {
        Random rand = new Random();
        int num = rand.nextInt(3)+1;

        return switch (num) {
            case 1 -> "ITO";
            case 2 -> "SDE";
            case 3 -> "SCO";
            case 4 -> "DBO";
            default -> "SCO";
        };
    }


    // Returnerer liste med fag. Hver fag indeholder en int med fremmødeprocent.
    public List<Subject> getSubjectAttendance(){
        return myAbsenceManager.getSubjectAttendance();
    }

    public static void main(String[] args) {
        AbsenceModel myabs = new AbsenceModel();

        List<AbsentDay> list = myabs.getAbsentDaysList();

        for ( AbsentDay day : list){
            System.out.println("AbsentDay: " + day.getDate() + " subject: " + day.getSubject());
        }

    }

}
