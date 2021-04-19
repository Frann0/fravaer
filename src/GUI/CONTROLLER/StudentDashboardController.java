package GUI.CONTROLLER;
import BE.*;
import BLL.DataGenerator;
import GUI.MODEL.StudentModel;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.value.ObservableMapValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class StudentDashboardController implements Initializable {
    @FXML
    private TableView<Attendance> tblAbsence;
    @FXML
    private TableColumn<Attendance, LocalDateTime> tblDate;
    @FXML
    private TableColumn<Attendance, String> tblSubject;
    @FXML
    private CategoryAxis catAxis;
    @FXML
    private NumberAxis numAxis;
    @FXML
    private BarChart chartAbcence;

    //private AbsenceManager absenceManager = new AbsenceManager();

    //private ObservableList<Absence> absence = FXCollections.observableArrayList();

    private User user = null;

    private Student loggedInStudent = null;
    XYChart.Series data = new XYChart.Series();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        chartAbcence.setPrefSize(522, 183);
        numAxis.setAutoRanging(false);

        catAxis.setLabel("Fag");

        numAxis.setLabel("Procent fravær");

        //BarChart barChart = new BarChart(xA,yA);
        data.setName("Fravær");

        /*
        //provided data
        AbsenceManager ab = new AbsenceManager();
        ArrayList<Class> absence = ab.getStudentAbsence("madsq");

        for (Class sub : absence) {
            data.getData().add(new XYChart.Data(sub.getName(), sub.getAbsence()));
        }


         */
        chartAbcence.getData().add(data);

    }

    public void setUser(User user) {
        /*
        System.out.println(user.getAttendance());
        this.user = user;
         */

        //TODO: MEGET CRUDE, ryd op.
        List<Student> students = StudentModel.getInstance().getStudents();

        for (Student s : students){
            if (user.getId() == s.getId()){
                loggedInStudent = s;
            }
        }
        if (loggedInStudent != null) {
            XYChart.Series totalAbsence = DataGenerator.getAbsenceData(loggedInStudent);

            chartAbcence.getData().addAll(totalAbsence);
        }

        List<Attendance> studentAttendances = loggedInStudent.getAttendances();

        ObservableList<Attendance> absences = FXCollections.observableArrayList();

        for (Attendance a : studentAttendances){
            if (!a.isAttended()){
                absences.add(a);
                //System.out.println(a.getLecture().getLectureDate() + " : " + a.getLecture().getSubject());
                System.out.println(loggedInStudent.getLectures());
            }
        }
        //absence.addAll(user.getAttendance());
        tblAbsence.setItems(absences);


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
/*
        tblDate.setCellFactory(d -> new TableCell<Attendance, LocalDateTime>() {
            @Override
            protected void updateItem(LocalDateTime date, boolean empty) {
                super.updateItem(date, empty);
                if (empty) {
                    setText("");
                } else {
                    setText(formatter.format(date));
                }
            }
        });

 */
        //tblDate.setCellValueFactory(cellData -> cellData.getValue().getLecture().getLectureDate());
        tblSubject.setCellValueFactory(s -> new ReadOnlyStringWrapper(s.getValue().getLecture().getSubject().getName()));
    }
}
