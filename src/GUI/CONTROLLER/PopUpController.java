package GUI.CONTROLLER;

import BE.Student;
import BE.User;
import BLL.AttendanceManager;
import BLL.LoginManager;
import GUI.MODEL.AttendanceModel;
import GUI.MODEL.LoginModel;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.time.LocalDateTime;

public class PopUpController {
    @FXML
    private AnchorPane root;
    private Student student;


    public void handleYes(){
        Stage root1 = (Stage) root.getScene().getWindow();
        AttendanceModel attendanceModel = new AttendanceModel();
        if(user !=null&& attendanceModel.registerAttendance(user,LocalDateTime.now())){
            System.out.println("Registreret tilstedeværelse for " + user.getUsername() + " : " + LocalDateTime.now());
        }else{
            System.out.println("Ikke registreret tilstedeværelse");
        }

        root1.close();
    }

    public void handleNo(){
        System.out.println("Ikke registreret tilstedeværelse");
        Stage root1 = (Stage) root.getScene().getWindow();

        root1.close();
    }

    public void setUser(User user) {
        this.user = user;
    }
}
