package GUI.MODEL;


import BE.Student;
import BE.User;
import BLL.LoginManager;
import DAL.DB.UserDAL;

import java.util.List;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class AttendanceModel {
    UserDAL userDAL = new UserDAL();
    private List<Student> students = userDAL.getStudents();
    private List<Student> debugStudents = LoginManager.getDebugStudents();
    private Student student;


    //@TODO remember to change debugStudents to students
    public boolean registerAttendance(User user, LocalDateTime date){
        debugStudents.forEach(student -> {
            if(student.getId()==user.getId())
                this.student=student;
        });
        if(student!=null){
            student.registerAttendance(date);
            return true;
        }
        return false;
    }

}

