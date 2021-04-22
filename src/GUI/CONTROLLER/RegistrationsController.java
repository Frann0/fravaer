package GUI.CONTROLLER;

import BE.*;
import BLL.DataGenerator;
import GUI.MODEL.LoginModel;
import GUI.MODEL.StudentModel;
import javafx.beans.property.ReadOnlyBooleanProperty;
import javafx.beans.property.ReadOnlyBooleanWrapper;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;

public class RegistrationsController implements Initializable {
    @FXML
    private TableView<Attendance> tblView;
    @FXML
    private TableColumn<Attendance, String> tblDato;
    @FXML
    private TableColumn<Attendance, String> tblFag;
    @FXML
    private TableColumn<Attendance, Boolean> tblPresent;

    private Student loggedInStudent = null;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    //TODO VIRKER IKKE PT
    public void setUser(User user) {
        List<Student> students = StudentModel.getInstance().getStudents();
        for (Student s : students){
            if (user.getId() == s.getId()){
                loggedInStudent = s;
            }
        }
        List<Attendance> attendanceList = loggedInStudent.getAttendances();
        ObservableList<Attendance> attendances = FXCollections.observableArrayList();

        attendances.addAll(attendanceList);

        tblView.setItems(attendances);
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        tblDato.setCellValueFactory(d -> new ReadOnlyObjectWrapper(d.getValue().getLecture().getLectureDate().toLocalDate().format(format)));
        tblFag.setCellValueFactory(s -> new ReadOnlyStringWrapper(s.getValue().getLecture().getSubject().getName()));
        tblPresent.setCellValueFactory(p -> new ReadOnlyBooleanWrapper(p.getValue().isAttended()));
    }
}
