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
    static List<String> days = Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday");

    public static BarChart getStudentAbsence(Student student) {
        return getBarchartFromCollection(student.getAbsence(), "Absence",student.toString() + "'s Absence","Absence");
    }

    public static BarChart getStudentAttendance(Student student) {
        return getBarchartFromCollection(student.getAttendedDates(),"Attendance",student.toString() + "'s Attendance", student.toString());
    }

    public static BarChart getStudentAttendanceSubject(Student student, Subject subject) {
        return getBarchartFromCollection(student.getAttendedDates(subject),"Attendance subject", student.toString() + "'s attendance in " + subject.getName(), subject.getName());
    }

    public static BarChart getStudentAbsenceSubject(Student student, Subject subject) {
        return getBarchartFromCollection(student.getAbsence(subject), "Absence", subject.getName() + "'s absence in " + subject.getName(), subject.getName());
    }

    public static BarChart getSubjectAttendance(Subject subject) {
        return getBarchartFromCollection(subject.getDates(), "subject Attendance", subject.getName(), subject.getName());
    }

    public static BarChart getStudentTotalAbsence(Student student){
        return getBarchartFromCollection(student.getAbsence(), "Absence",student.toString() + "'s absence", "Total Absence");
    }

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
        for (int i = 0; i <= 4; i++) {
            series.getData().add(new XYChart.Data<>(days.get(i), dayFreq[i]));
        }
        barChart.getData().add(series);

        return barChart;
    }

    public BarChart getAttendance() {
        return null;
    }

    private static int[] getAsWeekdayArray(Collection<LocalDate> dates) {
        int[] dayFreq = new int[5];
        dates.forEach(d -> {
            if (d.getDayOfWeek().getValue() < 6)
                dayFreq[d.getDayOfWeek().getValue() - 1] += 1;
        });
        return dayFreq;
    }
}
