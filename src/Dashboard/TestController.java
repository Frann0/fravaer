package Dashboard;

import BE.AbsentDay;
import BE.User;
import BLL.AbsenceManager;
import BLL.LoginManager;
import Mock.Absence;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class TestController implements Initializable {
    @FXML
    private TableView<User> test;
    @FXML
    private TableColumn<AbsentDay, LocalDate> tblDate;
    @FXML
    private TableColumn<AbsentDay, String> tblSubject;
    @FXML
    private BarChart chartAbcence;

    private AbsenceManager absenceManager = new AbsenceManager();

    private ObservableList<Absence> absence = FXCollections.observableArrayList();

    private User user = null;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

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
