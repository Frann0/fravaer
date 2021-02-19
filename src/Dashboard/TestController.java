package Dashboard;

import BE.AbsentDay;
import BE.Subject;
import BE.User;
import BLL.AbsenceManager;
import BLL.LoginManager;
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

public class TestController implements Initializable {
    @FXML
    private TableView<User> test;
    @FXML
    private TableColumn<AbsentDay, LocalDate> tblDate;
    @FXML
    private TableColumn<AbsentDay, String> tblSubject;
    @FXML
    private CategoryAxis catAxis;
    @FXML
    private NumberAxis numAxis;
    @FXML
    private BarChart chartAbcence;

    private AbsenceManager absenceManager = new AbsenceManager();

    private ObservableList<Absence> absence = FXCollections.observableArrayList();

    private User user = null;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        chartAbcence.setPrefSize(522,183);
        catAxis.setLabel("Fag");

        numAxis.setLabel("Procent fravær");

        //BarChart barChart = new BarChart(xA,yA);

        XYChart.Series data = new XYChart.Series();
        data.setName("Fravær");

        //provided data

        {
            AbsenceManager ab =  new AbsenceManager();
            ArrayList<Subject> absence = ab.getStudentAbsence("madsq");

            for(Subject sub : absence)
                data.getData().add(new XYChart.Data(sub.getName(),sub.getAbsence()));
        }
        chartAbcence.getData().add(data);

    }

    public void setUser(User user) {
        this.user = user;
    }

    public void initValues(){
        if (user != null){
            absence.addAll(user.getAttendance());
            System.out.println(absence);

            tblDate.setCellValueFactory(new PropertyValueFactory<>("username"));
            tblSubject.setCellValueFactory(new PropertyValueFactory<>("password"));
        }
    }
}
