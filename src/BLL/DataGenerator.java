package BLL;

import BE.Attendance;
import BE.Lecture;
import BE.Student;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.util.*;

public class DataGenerator {
    private static List<String> subjects = new ArrayList();
    private static Map<String, Integer> subjectAttendance = new HashMap<>();
    private static Map<String, Integer> subjectAbsence = new HashMap<>();

    /**
     * Gets the overall attendance of the given subset of students
     *
     * @param className the title of the series
     * @param students  the list of students you want to examine
     * @return A Series of XYChart of the attendance to subjects
     */
    public XYChart.Series<String, Number> getAttendanceData(String className, List<Student> students) {
        return getStringNumberSeries(className, students, subjectAttendance);
    }

    /**
     * Gets the overall attendance of the given subset of students
     *
     * @param className the title of the series
     * @param students  the list of students you want to examine
     * @return A Series of XYChart of the absence to subjects
     */
    public XYChart.Series<String, Number> getAbsenceData(String className, List<Student> students) {
        return getStringNumberSeries(className, students, subjectAbsence);
    }

    /**
     * calls the getStringNumberSeries to retrieve a series of data
     *
     * @param student the student you want to examine
     * @return a attendance data series split by subject
     */
    public XYChart.Series<String, Number> getAttendanceData(Student student) {
        return getStringNumberSeries(student.getFirstName() + " " + student.getLastName(), student, subjectAttendance);
    }

    /**
     * calls the getStringNumberSeries to retrieve a series of data
     *
     * @param student the student you want to examine
     * @return a absence data series split by subject
     */
    public XYChart.Series<String, Number> getAbsenceData(Student student) {
        return getStringNumberSeries(student.getFirstName() + " " + student.getLastName(), student, subjectAbsence);
    }


    /**
     * Uses the mapOfRawData, student list and series title to create a series of data
     *
     * @param seriesTitle  the title of the series
     * @param students     the students you want to examine
     * @param mapOfRawData the map of raw data
     * @return A XYChart of the data with subjects on the x axis, and attendance/absence on the y-axis
     */
    private static XYChart.Series<String, Number> getStringNumberSeries(String seriesTitle, List<Student> students, Map<String, Integer> mapOfRawData) {
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName(seriesTitle);
        students.forEach(s -> updateAttendanceMap(s, false));
        List<String> subjects = new ArrayList<>(mapOfRawData.keySet());
        subjects.sort(Comparator.comparingInt(mapOfRawData::get));
        for (String subject : subjects)
            series.getData().add(new XYChart.Data<>(subject, mapOfRawData.get(subject)));
        return series;
    }

    /**
     * Uses the mapOfRawData, student and series title to create a series of data
     *
     * @param seriesTitle  the title of the series
     * @param student      the students you want to examine
     * @param mapOfRawData the map of raw data
     * @return A XYChart of the data with subjects on the x axis, and attendance/absence on the y-axis
     */
    private static XYChart.Series<String, Number> getStringNumberSeries(String seriesTitle, Student student, Map<String, Integer> mapOfRawData) {
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName(seriesTitle);
        updateAttendanceMap(student, true);
        List<String> subjects = new ArrayList<>(mapOfRawData.keySet());
        subjects.sort(Comparator.comparingInt(mapOfRawData::get));
        for (String subject : subjects)
            series.getData().add(new XYChart.Data<>(subject, mapOfRawData.get(subject)));

        return series;
    }

    /**
     * Updates the attendance map, which maps subjects to the amount of days the student(s) have attended
     *
     * @param student      the student
     * @param clearOldData clears old data when true
     */
    private static void updateAttendanceMap(Student student, boolean clearOldData) {
        //clears the subjects when true
        if (clearOldData)
            subjects.clear();
        //adds missing subjects to the subjects list
        student.getLectures().forEach(l ->
        {
            if (!subjects.contains(l.getSubject().getName()))
                subjects.add(l.getSubject().getName());
        });
        //clears data
        if (clearOldData) {
            subjects.forEach(s -> {
                subjectAttendance.put(s, 0);
                subjectAbsence.put(s, 0);
            });
        }
        //resets the students attendance
        //student.setAttendance(0);
        //student.setAbsence(0);

        //runs through the students attendances increments attendance when is attended and decrements when not attended
        for (Attendance value : student.getAttendances()) {
            if (value.isAttended()) {
                subjectAttendance.put(value.getLecture().getSubject().getName(), subjectAttendance.getOrDefault(value.getLecture().getSubject().getName(), 0) + 1);
                //student.setAttendance(student.getAttendance() + 1);
            } else {
                subjectAbsence.put(value.getLecture().getSubject().getName(), subjectAbsence.getOrDefault(value.getLecture().getSubject().getName(), 0) + 1);
                //student.setAbsence(student.getAbsence() + 1);
            }
        }
    }

    public static void debugTest() {
        Random r = new Random();
        List<Student> students = new ArrayList<>();
        List<Lecture> lectures = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            lectures.add(new Lecture());
        }

        // Redundant due to Carlo's changes...
//        for (int i = 0; i < lectures.size(); i++)
//            lectures.get(i).setSubjectName("subject " + i);

        for (int i = 0; i < 3; i++)
            students.add(new Student());

        for (int i = 0; i < students.size(); i++) {
            students.get(i).setFirstName("student " + i);
            students.get(i).setLectures(lectures);
        }

        students.forEach(student -> {
            for (int i = 0; i < 1000; i++) {
                Lecture lecture = student.getLectures().get(r.nextInt(student.getLectures().size()));
                if (r.nextInt(10) < 2)
                    student.getAttendances().add(new Attendance(lecture, false));
                else
                    student.getAttendances().add(new Attendance(lecture, true));
            }
        });
        List<String> subjects = new ArrayList<>();
        lectures.forEach(s -> subjects.add(s.getSubject().getName()));

        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Subjects");
        xAxis.setCategories(FXCollections.observableList(subjects));
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Attendance");

        BarChart<String, Number> bc = new BarChart<>(xAxis, yAxis);

        xAxis = new CategoryAxis();
        xAxis.setLabel("Subjects");
        xAxis.setCategories(FXCollections.observableList(subjects));
        yAxis = new NumberAxis();
        yAxis.setLabel("Absence");
        BarChart<String, Number> bc2 = new BarChart<>(xAxis, yAxis);

        DataGenerator dataGenerator = new DataGenerator();
        bc.getData().add(dataGenerator.getAttendanceData("badclass", students));
        bc2.getData().add(dataGenerator.getAbsenceData("badClass", students));

        /*
        for(Student student : students) {
            bc.getData().add(dataGenerator.getAttendanceData(student));
            bc2.getData().add(dataGenerator.getAbsenceData(student));
        }

         */


        FlowPane fp = new FlowPane();
        fp.getChildren().addAll(bc, bc2);

        Stage stage = new Stage();
        Scene scene = new Scene(fp);
        stage.setScene(scene);
        stage.show();
    }
}
