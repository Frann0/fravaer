package BE;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    Student student = new Student();
    Lecture lecture = new Lecture();

    @Test
    void registerAttendance() {
        student.getLectures().add(lecture);
        lecture.setDate(LocalDateTime.now());
        lecture.setLectureDuration(Duration.ofMinutes(15));
        assertTrue(student.registerAttendance(LocalDateTime.now()), "Can attend a valid date");
        assertFalse(student.registerAttendance(LocalDateTime.now().minus(Duration.ofMinutes(16))), "Cant attend a invalid time");
        assertFalse(student.registerAttendance(LocalDateTime.now().minus(Duration.ofDays(1))), "Cant attend a invalid date");

    }
}