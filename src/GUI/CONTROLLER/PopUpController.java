package GUI.CONTROLLER;

import BE.Student;
import BE.User;
import GUI.MODEL.AttendanceModel;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.time.LocalDateTime;

public class PopUpController {
    @FXML
    private AnchorPane root;
    private Student student;


    public void handleYes(){
        System.out.println("Registreret fravær for " + student.getUsername() + " : " + LocalDateTime.now());
        Stage root1 = (Stage) root.getScene().getWindow();

        AttendanceModel attendanceModel = new AttendanceModel();
        attendanceModel.registerAttendance(student,LocalDateTime.now());

        root1.close();
    }

    public void handleNo(){
        System.out.println("Ikke registreret fravær");
        Stage root1 = (Stage) root.getScene().getWindow();

        root1.close();
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
