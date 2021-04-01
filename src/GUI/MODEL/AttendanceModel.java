package GUI.MODEL;


import BE.User;

import java.time.LocalDateTime;

public class AttendanceModel {
    private User user;
    private LocalDateTime date;
    //AbsenceManager myAbsenceManager = new AbsenceManager();

    public void registerAttendance(User u, LocalDateTime date){
        user = u;
        this.date = date;
    }
    /*public List<Class> getSubjectAttendance() {
        return myAbsenceManager.getSubjectAttendance();
    }

     */

}

