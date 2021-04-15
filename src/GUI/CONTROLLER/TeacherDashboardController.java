package GUI.CONTROLLER;

import BE.Student;
import BE.Subject;
import BE.User;
import BLL.DataGenerator;
import GUI.MODEL.StudentModel;
import com.jfoenix.controls.JFXComboBox;
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

import java.net.URL;
import java.util.ResourceBundle;

public class TeacherDashboardController implements Initializable {
    @FXML
    private BarChart chartOverallAttendance;
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
    private JFXComboBox subjectFilterCombobox;

    private User user;

    private XYChart.Series data = new XYChart.Series();
    private StudentModel studentModel = StudentModel.getInstance();

    private ObservableList<Student> students = FXCollections.observableArrayList();
    private ObservableList<Subject> subjects = FXCollections.observableArrayList();

    private Subject selectedSubject;
    private DataGenerator attendanceDataGenerator;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //Hide initial student abcence charts
        chartIndividualDay.setVisible(false);
        chartIndividualSubject.setVisible(false);

        initializeCombobox();
        initializeTable();
    }

    /**
     * Initialize the subject filter combo box.
     */
    private void initializeCombobox() {
        subjects.setAll(studentModel.getSubjects());
        subjectFilterCombobox.setItems(subjects);
    }

    /**
     * Initialize the table view of the class. Should only be called once in the initialize method.
     */
    private void initializeTable() {

        // Assign the table columns to automatically update their cell.
        tblFirstname.setCellValueFactory(cellData -> cellData.getValue().getFirstNameProperty());
        tblLastname.setCellValueFactory(cellData -> cellData.getValue().getLastNameProperty());

        // Then assign the table to get the observable student list.
        tblStudents.setItems(students);

        // Now add all the students.
        students.setAll(studentModel.getStudents());

        // Initialize the filter by subject functionality (combo box).
        filterStudentsBySubject();

        initializeCharts();
        getAverageTotalAttendance();
    }

    private void initializeCharts() {
        //
        //INDIVIDUAL DAY ABSENCE
        //

        individualDayNum.setLabel("Procent fravær");

        individualDayNum.setLayoutY(100);

        data.setName("Fravær");

        //provided data
        XYChart.Series data1 = new XYChart.Series();
        individualDayNum.setAutoRanging(false);

        data1.getData().add(new XYChart.Data("Mon", (int) (Math.random() * 50 + 1)));
        data1.getData().add(new XYChart.Data("Tue", (int) (Math.random() * 50 + 1)));
        data1.getData().add(new XYChart.Data("Wed", (int) (Math.random() * 50 + 1)));
        data1.getData().add(new XYChart.Data("Thu", (int) (Math.random() * 50 + 1)));
        data1.getData().add(new XYChart.Data("Fri", (int) (Math.random() * 50 + 1)));

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

        data2.getData().add(new XYChart.Data("SCO", (int) (Math.random() * 50 + 1)));
        data2.getData().add(new XYChart.Data("ITO", (int) (Math.random() * 50 + 1)));
        data2.getData().add(new XYChart.Data("DBO", (int) (Math.random() * 50 + 1)));
        data2.getData().add(new XYChart.Data("SDE", (int) (Math.random() * 50 + 1)));

        chartIndividualSubject.getData().addAll(data2);

        //END OF CHARTS
    }

    /**
     * Filter the students in a class by the selected subject. Should only be called once in the initialize method.
     */
    private void filterStudentsBySubject() {
        subjectFilterCombobox.getSelectionModel().selectedItemProperty().addListener(((observableValue, oldValue, newValue) -> {
            selectedSubject = (Subject) newValue;
            if (selectedSubject != null) {
                students.setAll(studentModel.getStudentsBySubject(selectedSubject));
                System.out.println(String.format("Selected subject: %s", selectedSubject.getName()));
            }
        }));
    }

    private void getAverageTotalAttendance() {

        // TODO: Make the average attendance chart work.
        XYChart.Series data = new XYChart.Series();
        data.setName("Gennemsnitlige Fravær");
        overallNumAxis.setLabel(data.getName());
        overallNumAxis.setAutoRanging(false);

        data.getData().add(new XYChart.Data("SCO", (int) (Math.random() * 50 + 1)));
        data.getData().add(new XYChart.Data("ITO", (int) (Math.random() * 50 + 1)));
        data.getData().add(new XYChart.Data("DBO", (int) (Math.random() * 50 + 1)));
        data.getData().add(new XYChart.Data("SDE", (int) (Math.random() * 50 + 1)));
        chartOverallAttendance.setLegendVisible(false);
        chartOverallAttendance.getData().addAll(data);
        //chartOverallAttendance.getData().add(dataGenerator.getAttendanceData("badclass", students));
    }

    /**
     * Set the current logged in user.
     *
     * @param user The user to assign as logged in.
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Selects a student, and shows the individual charts for that specific student.
     */
    public void selectStudent() {
        Student selectedStudent = tblStudents.getSelectionModel().getSelectedItem();
        if (selectedStudent != null) {

            //TODO: set data to charts from model.
            XYChart.Series days = new XYChart.Series<>();

            days.setName("Individual day absence");
            //Todo: Replace random data with data from model
            days.getData().add(new XYChart.Data<>("Mon", (int) (Math.random() * 50 + 1)));
            days.getData().add(new XYChart.Data<>("Tue", (int) (Math.random() * 50 + 1)));
            days.getData().add(new XYChart.Data<>("Wed", (int) (Math.random() * 50 + 1)));
            days.getData().add(new XYChart.Data<>("Thu", (int) (Math.random() * 50 + 1)));
            days.getData().add(new XYChart.Data<>("Fri", (int) (Math.random() * 50 + 1)));


            XYChart.Series classes = new XYChart.Series<>();

            classes.setName("Individual class absence");
            //Todo: Replace random data with data from model
            classes.getData().add(new XYChart.Data<>("SCO", (int) (Math.random() * 50 + 1)));
            classes.getData().add(new XYChart.Data<>("DBOS", (int) (Math.random() * 50 + 1)));
            classes.getData().add(new XYChart.Data<>("SDE", (int) (Math.random() * 50 + 1)));
            classes.getData().add(new XYChart.Data<>("ITO", (int) (Math.random() * 50 + 1)));

            chartIndividualSubject.getData().addAll(classes);
            chartIndividualDay.getData().addAll(days);

            chartIndividualSubject.setVisible(true);
            chartIndividualDay.setVisible(true);
        }
    }
}
