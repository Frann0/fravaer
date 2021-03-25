package BLL;

import BE.Student;
import BE.Subject;
import javafx.collections.FXCollections;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class BarChartUtility {
    /**
     * The days we analyze
     */
    static List<String> days = Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday");

    /**
     * Uses the student's get absence method to make a barchart of the students daily absence in the student's subjects
     * @param student the student of interest
     * @return A barchart with the students daily absence in the student's subjects
     */
    public static BarChart getStudentAbsence(Student student) {
        return getBarchartFromCollection(student.getAbsence(), "Absence",student.toString() + "'s Absence","Absence");
    }

    /**
     * Uses the student's get attendance method to make a barchart of the students daily attendance in the student's subjects
     * @param student the student of interest
     * @return a barchart of the students daily attendance in the student's subjects
     */
    public static BarChart getStudentAttendance(Student student) {
        return getBarchartFromCollection(student.getAttendedDates(),"Attendance",student.toString() + "'s Attendance", student.toString());
    }

    /**
     * Uses the student's getAttendedDates method to make a barchart of the student's daily attendance in the given subject
     * @param student the student of interest
     * @param subject the subject of interest
     * @return a barchart of the student's daily attendance in the subject
     */
    public static BarChart getStudentAttendanceSubject(Student student, Subject subject) {
        return getBarchartFromCollection(student.getAttendedDates(subject),"Attendance subject", student.toString() + "'s attendance in " + subject.getName(), subject.getName());
    }

    /**
     * Uses the student's getAbsence method to make a barchart of the student's daily absence in the given subject
     * @param student the student of interest
     * @param subject the subject of interest
     * @return a barchart of the student's daily absence in the subject
     */
    public static BarChart getStudentAbsenceSubject(Student student, Subject subject) {
        return getBarchartFromCollection(student.getAbsence(subject), "Absence", subject.getName() + "'s absence in " + subject.getName(), subject.getName());
    }

    /**
     * Uses the subject's attendance to make a chart of the subjects daily attendance
     * @param subject the subject of interest
     * @return a barchart of the daily attendance in the given subject
     */
    public static BarChart getSubjectAttendance(Subject subject) {
        return getBarchartFromCollection(subject.getDates(), "subject Attendance", subject.getName(), subject.getName());
    }

    // @TODO make get subject absence method and class absence & attendance method
    public static BarChart getSubjectAbsence(Subject subject){
        return null;
    }


    // @TODO make get class attendance method
    public static BarChart getClassAttendance(Subject subject) {
        return null;
    }

    // @TODO make get class absence method
    public static BarChart getClassAbsence(Subject subject){
        return null;
    }

    /**
     * Uses the dates in source to make a array of frequencies through the getAsWeekdayArray method
     * @param source the source of interest
     * @param label The yAxis label
     * @param title The title of the array
     * @param seriesName Name of the series
     * @return a Barchart of the daily frequency of the source
     */
    private static BarChart getBarchartFromCollection(Collection<LocalDate> source, String label,String title, String seriesName) {
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setCategories(FXCollections.<String>observableList(days));
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel(label);
        BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
        barChart.setTitle(title);

        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName(seriesName);
        int[] dayFreq = getAsWeekdayArray(source);
        for (int i = 0; i < days.size(); i++) {
            series.getData().add(new XYChart.Data<>(days.get(i), dayFreq[i]));
        }
        barChart.getData().add(series);

        return barChart;
    }

    /**
     * Iterates through the days, to get the frequency of each day, and returns a list of the frequencies
     * @param dates the days of interest
     * @return a array of the frequency of each day
     */
    private static int[] getAsWeekdayArray(Collection<LocalDate> dates) {
        int[] dayFreq = new int[days.size()];
        dates.forEach(d -> {
            if (d.getDayOfWeek().getValue() <= days.size())
                dayFreq[d.getDayOfWeek().getValue() - 1] += 1;
        });
        return dayFreq;
    }
}
