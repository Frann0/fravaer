package GUI.CONTROLLER;

<<<<<<< HEAD:src/GUI/CONTROLLER/StudentDashboardController.java
import BE.Class;
import BE.User;
=======
import BE.Subject;
import BE.User;
import BLL.AbsenceManager;
>>>>>>> pr/1:src/GUI/CONTROLLER/StudentdbController.java
import Mock.Absence;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class StudentDashboardController implements Initializable {
    @FXML
    private TableView<Absence> tblAbsence;
    @FXML
    private TableColumn<Absence, LocalDate> tblDate;
    @FXML
    private TableColumn<Absence, String> tblSubject;
    @FXML
    private CategoryAxis catAxis;
    @FXML
    private NumberAxis numAxis;
    @FXML
    private BarChart chartAbcence;

    private AbsenceManager absenceManager = new AbsenceManager();

    private ObservableList<Absence> absence = FXCollections.observableArrayList();

    private User user = null;
    XYChart.Series data = new XYChart.Series();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        chartAbcence.setPrefSize(522, 183);
        numAxis.setAutoRanging(false);

        catAxis.setLabel("Fag");

        numAxis.setLabel("Procent fravær");

        //BarChart barChart = new BarChart(xA,yA);
        data.setName("Fravær");

        //provided data
        AbsenceManager ab = new AbsenceManager();
        ArrayList<Class> absence = ab.getStudentAbsence("madsq");

        for (Class sub : absence) {
            data.getData().add(new XYChart.Data(sub.getName(), sub.getAbsence()));
        }

        chartAbcence.getData().add(data);

    }

    public void setUser(User user) {
        System.out.println(user.getAttendance());
        this.user = user;

        absence.addAll(user.getAttendance());
        tblAbsence.setItems(absence);
        tblDate.setCellValueFactory(new PropertyValueFactory<>("lectureDate"));
        tblSubject.setCellValueFactory(new PropertyValueFactory<>("subjectName"));
    }

    public void initValues() {
        if (user != null) {
        }
    }
}
