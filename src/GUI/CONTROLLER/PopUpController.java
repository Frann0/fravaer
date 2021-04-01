package GUI.CONTROLLER;

import BE.User;
import GUI.MODEL.AttendanceModel;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.time.LocalDateTime;

public class PopUpController {
    @FXML
    private AnchorPane root;
    private User user;


    public void handleYes(){
        System.out.println("Registreret fravær for " + user.getUsername() + " : " + LocalDateTime.now());
        Stage root1 = (Stage) root.getScene().getWindow();

        AttendanceModel attendanceModel = new AttendanceModel();
        attendanceModel.registerAttendance(user,LocalDateTime.now());

        root1.close();
    }

    public void handleNo(){
        System.out.println("Ikke registreret fravær");
        Stage root1 = (Stage) root.getScene().getWindow();

        root1.close();
    }

    public void setUser(User currentUser) {
        user = currentUser;
    }
}
