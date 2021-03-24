package BE;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    Student s1 = new Student(0, UserRole.Student, "Dennis", "PC", "Dennis", "PC");
    Student s2 = new Student(1, UserRole.Student, "Dennis2", "PC2", "Dennis2", "PC2");
    Subject subject = new Subject("subject");
    Subject subject2 = new Subject("subject");

    @Test
    void getAttendedDates() {
        //Adds lecture to the lecture map
        subject.getLectures().put(LocalDateTime.now().minusHours(1), LocalDateTime.now().plusHours(1));
        subject.getLectures().put(LocalDateTime.now().plusDays(1).minusHours(1), LocalDateTime.now().plusDays(1).plusHours(1));
        //adds subject to the students subjects
        s1.getSubjects().add(subject);
        s2.getSubjects().add(subject);

        s1.getAttendance().attendDate();
        s1.getAttendance().attendDate(LocalDateTime.now().plusDays(1));
        s2.getAttendance().attendDate();

        assert s1.getAttendedDates().size()==2;
        assert s2.getAttendedDates().size()==1;
    }

    @Test
    void getAbsence() {
        //Adds lecture to the lecture map
        subject.getLectures().put(LocalDateTime.now().minusHours(1), LocalDateTime.now().plusHours(1));
        subject.getLectures().put(LocalDateTime.now().plusDays(1).minusHours(1), LocalDateTime.now().plusDays(1).plusHours(1));

        subject2.getLectures().put(LocalDateTime.now().plusDays(2).minusHours(1), LocalDateTime.now().plusDays(2).plusHours(1));
        subject2.getLectures().put(LocalDateTime.now().minusDays(1).minusHours(1), LocalDateTime.now().minusDays(1).plusHours(1));
        //adds subject to the students subjects
        s1.getSubjects().add(subject);
        s2.getSubjects().add(subject);
        s1.getSubjects().add(subject2);
        s2.getSubjects().add(subject2);

        s1.getAttendance().attendDate();
        s1.getAttendance().attendDate(LocalDateTime.now().plusDays(1));
        s1.getAttendance().attendDate(LocalDateTime.now().plusDays(2));
        s1.getAttendance().attendDate(LocalDateTime.now().minusDays(1));
        s2.getAttendance().attendDate();

        assert subject.getDates().size()==2;
        assert subject2.getDates().size()==2;

        assert s1.getAbsence().size()==0;
        assert s2.getAbsence().size()==3;

        assert s1.getAbsence(subject).size()==0;
        assert s2.getAbsence(subject).size()==1;
    }
}