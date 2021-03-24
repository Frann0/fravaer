package BE;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Student extends User{
    private final Attendance attendance = new Attendance(this);
    private Set<LocalDate> attendedDates = new HashSet<>();
    private static List<LocalDate> allAttendedDates = new ArrayList<>();

    public Student(int id, UserRole role, String username, String password, String firstName, String lastName) {
        super(id, role, username, password, firstName, lastName);
    }

    public Student(int id, UserRole role, String username, String password, String firstName, String lastName, Set<LocalDate> attendedDates) {
        super(id, role, username, password, firstName, lastName);
        this.attendedDates=attendedDates;
    }

    /**
     * Gets the list of attended dates
     *
     * @return the list of attended dates
     */
    public Set<LocalDate> getAttendedDates() {
        return attendedDates;
    }

    /**
     * Adds a date to the list of attended dates.
     * @param localDate the date to add.
     */
    public void addDate(LocalDate localDate){
        attendedDates.add(localDate);
    }

    /**
     * Gets the list of attendances
     *
     * @return the list of attendance
     */
    public Attendance getAttendance() {
        return attendance;
    }

    /**
     * Gets the list of absent days
     *
     * @return the list of absent days
     */
    public List<LocalDate> getAbsence() {
        List<LocalDate> absence = new ArrayList<>();
        getAllSubjects().forEach(s -> {
            if (!attendedDates.containsAll(s.getDates())) {
                s.getDates().forEach(
                        d -> {
                            if (!attendedDates.contains(d))
                                absence.add(d);
                        }
                );
            }
        });
        return absence;
    }

    /**
     * Gets a list of absent days in a specific subject
     * @param subject the subject which the user is absent in.
     * @return A list of absent days where the user is absent in the subject.
     */
    public List<LocalDate> getAbsence(Subject subject) {
        List<LocalDate> absence = new ArrayList<>();
        if (!attendedDates.containsAll(subject.getDates())) {
            subject.getDates().forEach(
                    d -> {
                        if (!attendedDates.contains(d))
                            absence.add(d);
                    }
            );
        }
        return absence;
    }

    /**
     * Gets a list of attended days in a specific subject.
     * @param subject the subject where the user has attended.
     * @return a list of dates where the user was attending that specific subject.
     */
    public List<LocalDate> getAttendedDates(Subject subject) {
        List<LocalDate> subjectDates = new ArrayList<>(subject.getDates());
        subject.getDates().forEach(d -> {
            if (attendedDates.contains(d))
                subjectDates.add(d);
        });
        return subjectDates;
    }
}
