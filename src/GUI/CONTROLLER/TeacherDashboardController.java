package GUI.CONTROLLER;

import BE.User;
import DAL.UserDAL;
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
    private TableView<User> tblStudents;
    @FXML
    private TableColumn<User, String> tblFirstname;
    @FXML
    private TableColumn<User, String> tblLastname;
    @FXML
    private TableColumn<User, Integer> tblAbsence;
    @FXML
    private JFXComboBox dropSelector;

    private User user;

    private XYChart.Series data = new XYChart.Series();
    private UserDAL userDAL = new UserDAL();

    private ObservableList<User> students = FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
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

        students.addAll(userDAL.getStudents());
        tblStudents.setItems(students);

        tblFirstname.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        tblLastname.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        tblAbsence.setCellValueFactory(new PropertyValueFactory<>("totalAbsence"));

    }

    public void setUser(User user) {
        this.user = user;
        System.out.println(user.getClasses());
        dropSelector.getItems().addAll(user.getClasses());
    }
}
