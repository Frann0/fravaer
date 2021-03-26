package BE;

import java.time.LocalDate;
import java.time.LocalTime;

public class Lecture {
    private String subjectName;
    private LocalDate lectureDate;
    private LocalTime lectureTime;

    public Lecture(String subjectName, LocalDate lectureDate, LocalTime lectureTime){
        this.subjectName = subjectName;
        this.lectureDate = lectureDate;
        this.lectureTime = lectureTime;
    }

    public LocalTime getLectureTime() {
        return lectureTime;
    }

    public LocalDate getLectureDate() {
        return lectureDate;
    }
}
