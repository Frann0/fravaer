package BE;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class AttendanceTest {

    @Test
    void attendDate() {
        //Creates a student object
        Student student = new Student(0, UserRole.Student, "Dennis", "PC", "Dennis", "PC");
        //Creates a subject object
        Subject subject = new Subject("subject");
        //Adds lecture to the lecture map
        subject.getLectures().put(LocalDateTime.now().minusHours(1), LocalDateTime.now().plusHours(1));
        //adds subject to the students subjects
        student.getSubjects().add(subject);

        //checks if the student can attend a valid date
        assert student.getAttendance().attendDate();
        assert !student.getAttendance().attendDate(LocalDateTime.now().minusHours(2));
        assert !student.getAttendedDates().isEmpty();
        assert !subject.getDates().isEmpty();
    }
}