package BE;

import BLL.AttendanceManager;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class Student extends User {
    private int attendance;
    private int absence;
    private List<Lecture> lectures = new ArrayList<>();
    private List<Attendance> attendances = new ArrayList<>();
    private static final Duration REGISTRATION_BUFFER = Duration.ofMinutes(15);

    public Student() {
    }

    public Student(int id, UserRole role, String username, String password, String firstName, String lastName) {
        super(id, role, username, password, firstName, lastName);
        attendances = new ArrayList<>();
    }

    public Student(int id, UserRole role, String username, String password, String firstName, String lastName, List<Attendance> attendances) {
        super(id, role, username, password, firstName, lastName);
        this.attendances = attendances;
    }

    public Student(int id, UserRole role, String username, String password, String firstName, String lastName, List<Attendance> attendances, List<Lecture> lectures) {
        super(id, role, username, password, firstName, lastName);
        this.attendances = attendances;
        this.lectures = lectures;
    }

    public List<Lecture> getLectures() {
        return lectures;
    }

    public void setLectures(List<Lecture> lectures) {
        this.lectures = lectures;
    }

    public List<Attendance> getAttendances() {
        return attendances;
    }

    public void setAttendances(List<Attendance> attendances) {
        this.attendances = attendances;
    }

    public int getAttendance() {
        return attendance;
    }

    public void setAttendance(int attendance) {
        this.attendance = attendance;
    }

    public int getAbsence() {
        return absence;
    }

    public void setAbsence(int absence) {
        this.absence = absence;
    }

    /**
     * Tries to register attendance at the given date, and checks that the registration is within the users lectures
     *
     * @param registration the time you want to register
     * @return If the registration was valid or not
     */
    public boolean registerAttendance(LocalDateTime registration) {

        //Assigns the registrationDate to a variable for convenience
        LocalDate registrationDate = registration.toLocalDate();

        //Assigns the registrationTime to a variable for convenience
        LocalTime registrationTime = registration.toLocalTime();

        //A atomic boolean for returning the result of the registration attempt
        AtomicBoolean isValid = new AtomicBoolean(false);

        //Loops through the lectures
        for (Lecture lecture : this.getLectures()) {
            if (
                //Checks the registration date is the same as the lecture date
                    lecture.getDate().toLocalDate().equals(registrationDate) &&

                            //Checks the registration is within the lecture (minus the REGISTRATION_BUFFER)
                            registrationTime.isAfter(lecture.getDate().toLocalTime().minus(REGISTRATION_BUFFER)) &&

                            //Checks the registration is within the lecture (plus the REGISTRATION_BUFFER)
                            registrationTime.isBefore(LocalTime.from(lecture.getDate().plus(lecture.getLectureDuration()).plus(REGISTRATION_BUFFER)))
            ) {
                isValid.set(true);
                AttendanceManager.updateStudentAttendance(this, lecture, true);
            }
        }
        return isValid.get();
    }


}
