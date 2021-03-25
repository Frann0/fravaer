package BE;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;

class UserTest {
    Student s1 = new Student(0, UserRole.Student, "Dennis", "PC", "Dennis", "PC");
    Subject subject = new Subject("subject");
    Subject subject2 = new Subject("subject");
    Subject subject3 = new Subject("subject");

    Course course = new Course(0,"Course", new HashSet<>(),new HashSet<>());

    @Test
    void getSubjects() {
        //Check the subjects start as empty
        assert s1.getSubjects().isEmpty();

        // Check that it adds subjects properly
        s1.getSubjects().add(subject);
        assert s1.getSubjects().contains(subject);

        //Check that you can add a course after adding a subject
        course.getSubjects().add(subject2);
        course.getSubjects().add(subject3);
        s1.getCourses().add(course);
        assert s1.getAllSubjects().contains(subject);
        assert s1.getAllSubjects().contains(subject2);
        assert s1.getAllSubjects().contains(subject3);

        //check that you can add courses without adding a subject
        s1.getSubjects().clear();
        assert !s1.getAllSubjects().contains(subject);
        assert s1.getAllSubjects().contains(subject2);
        assert s1.getAllSubjects().contains(subject3);

        //Check that it removes all subjects in a course
        s1.getCourses().clear();
        assert !s1.getAllSubjects().contains(subject);
        assert !s1.getAllSubjects().contains(subject2);
        assert !s1.getAllSubjects().contains(subject3);
    }
}