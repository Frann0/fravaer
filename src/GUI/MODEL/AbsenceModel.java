package GUI.MODEL;

import BE.Class;

import java.util.List;


public class AbsenceModel {
    AbsenceManager myAbsenceManager = new AbsenceManager();

    public List<Class> getSubjectAttendance() {
        return myAbsenceManager.getSubjectAttendance();
    }

}

