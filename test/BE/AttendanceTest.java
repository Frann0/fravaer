package BE;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class AttendanceTest {

    @Test
    @DisplayName("User should be able to attend a lecture")
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
        assertTrue( student.getAttendance().attendDate(),"Can Attend a valid date!");
        assertFalse(student.getAttendance().attendDate(LocalDateTime.now().minusHours(2)), "cant attend a invalid date");
        assertTrue(student.getAttendance().attendDate(LocalDateTime.now().minusHours(1).minusMinutes(14)),"Can attend slightly before a lecture begins");
        assertFalse(student.getAttendedDates().isEmpty(), "The students valid date was added to the List of attended dates");
        assertFalse(subject.getDates().isEmpty(), "The subjects dates were updated");
    }
}