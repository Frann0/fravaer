package GUI.CONTROLLER;

import BE.Student;
import BE.User;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class TeacherDashboardController implements Initializable {
    @FXML
    private BarChart chartOverallAbsence;
    @FXML
    private BarChart chartIndividualDay;
    @FXML
    private BarChart chartIndividualSubject;
    @FXML
    private NumberAxis overallNumAxis;
    @FXML
    private NumberAxis individualDayNum;
    @FXML
    private NumberAxis individualSubNum;
    @FXML
    private TableView<Student> tblStudents;
    @FXML
    private TableColumn<Student, String> tblFirstname;
    @FXML
    private TableColumn<Student, String> tblLastname;
    @FXML
    private TableColumn<Student, Integer> tblAbsence;
    @FXML
    private JFXComboBox dropSelector;

    private User user;

    private XYChart.Series data = new XYChart.Series();
    //private UserDAL userDAL = new UserDAL();

    private ObservableList<Student> students = FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //Hide initial student abcence charts
        chartIndividualDay.setVisible(false);
        chartIndividualSubject.setVisible(false);

        //
        //OVERALL SUBJECT ABSENCE
        //

        //overallCatAxis.setLabel("FAG");
        overallNumAxis.setLabel("Total Procent Fravær");

        XYChart.Series data = new XYChart.Series();
        data.setName("Total Fravær");

        //provided data
        overallNumAxis.setAutoRanging(false);

        data.getData().add(new XYChart.Data("SCO",(int)(Math.random() * 50 + 1)));
        data.getData().add(new XYChart.Data("ITO",(int)(Math.random() * 50 + 1)));
        data.getData().add(new XYChart.Data("DBO",(int)(Math.random() * 50 + 1)));
        data.getData().add(new XYChart.Data("SDE",(int)(Math.random() * 50 + 1)));
        chartOverallAbsence.setLegendVisible(false);
        chartOverallAbsence.getData().addAll(data);

        //
        //INDIVIDUAL DAY ABSENCE
        //

        individualDayNum.setLabel("Procent fravær");

        individualDayNum.setLayoutY(100);

        data.setName("Fravær");

        //provided data
        XYChart.Series data1 = new XYChart.Series();
        individualDayNum.setAutoRanging(false);

        data1.getData().add(new XYChart.Data("Mon",(int)(Math.random() * 50 + 1)));
        data1.getData().add(new XYChart.Data("Tue",(int)(Math.random() * 50 + 1)));
        data1.getData().add(new XYChart.Data("Wed",(int)(Math.random() * 50 + 1)));
        data1.getData().add(new XYChart.Data("Thu",(int)(Math.random() * 50 + 1)));
        data1.getData().add(new XYChart.Data("Fri",(int)(Math.random() * 50 + 1)));

        chartIndividualDay.getData().addAll(data1);

        //
        //INDIVIDUAL SUBJECT ABSENCE
        //

        //individualSubCat.setLabel("FAG");
        individualSubNum.setLabel("Procent Fravær");

        XYChart.Series data2 = new XYChart.Series();
        data2.setName("Individual Fravær");

        //provided data
        individualSubNum.setAutoRanging(false);

        data2.getData().add(new XYChart.Data("SCO",(int)(Math.random() * 50 + 1)));
        data2.getData().add(new XYChart.Data("ITO",(int)(Math.random() * 50 + 1)));
        data2.getData().add(new XYChart.Data("DBO",(int)(Math.random() * 50 + 1)));
        data2.getData().add(new XYChart.Data("SDE",(int)(Math.random() * 50 + 1)));

        chartIndividualSubject.getData().addAll(data2);

        //END OF CHARTS

        //students.addAll(userDAL.getStudents());
        tblStudents.setItems(students);

        tblFirstname.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        tblLastname.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        tblAbsence.setCellValueFactory(new PropertyValueFactory<>("totalAbsence"));

    }

    public void setUser(User user) {
        this.user = user;
        //System.out.println(user.getClasses());
        //dropSelector.getItems().addAll(user.getClasses());
    }

    /**
     * Selects a student, and shows the individual charts for that specific student.
     */
    public void SelectStudent() {
        Student selectedStudent = tblStudents.getSelectionModel().getSelectedItem();
        if (selectedStudent != null){

            //TODO: set data to charts from model.
            XYChart.Series days = new XYChart.Series<>();

            days.setName("Individual day absence");
            //Todo: Replace random data with data from model
            days.getData().add(new XYChart.Data<>("Mon", (int)(Math.random() * 50 + 1)));
            days.getData().add(new XYChart.Data<>("Tue", (int)(Math.random() * 50 + 1)));
            days.getData().add(new XYChart.Data<>("Wed", (int)(Math.random() * 50 + 1)));
            days.getData().add(new XYChart.Data<>("Thu", (int)(Math.random() * 50 + 1)));
            days.getData().add(new XYChart.Data<>("Fri", (int)(Math.random() * 50 + 1)));


            XYChart.Series classes = new XYChart.Series<>();

            classes.setName("Individual class absence");
            //Todo: Replace random data with data from model
            classes.getData().add(new XYChart.Data<>("SCO", (int)(Math.random() * 50 + 1)));
            classes.getData().add(new XYChart.Data<>("DBOS", (int)(Math.random() * 50 + 1)));
            classes.getData().add(new XYChart.Data<>("SDE", (int)(Math.random() * 50 + 1)));
            classes.getData().add(new XYChart.Data<>("ITO", (int)(Math.random() * 50 + 1)));

            chartIndividualSubject.getData().addAll(classes);
            chartIndividualDay.getData().addAll(days);

            chartIndividualSubject.setVisible(true);
            chartIndividualDay.setVisible(true);
        }
    }
}
