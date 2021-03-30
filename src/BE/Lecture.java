package BE;

import java.time.LocalDate;
import java.time.LocalTime;

public class Lecture {
    private int lectureId;
    private String subjectName;
    private LocalDate lectureDate;
    private LocalTime lectureTime;

    public Lecture() {
    }

    public Lecture(int lectureId, String subjectName, LocalDate lectureDate, LocalTime lectureTime){
        this.lectureId = lectureId;
        this.subjectName = subjectName;
        this.lectureDate = lectureDate;
        this.lectureTime = lectureTime;
    }

    public Lecture(LocalDate date) {
        this.lectureDate = date;
    }

    public Lecture(String subject) {
        this.subjectName = subject;
    }

    public Lecture(String subjectName, LocalDate date) {
        this.subjectName = subjectName;
        this.lectureDate = date;
    }

    public int getLectureId() {
        return lectureId;
    }

    public void setLectureId(int lectureId) {
        this.lectureId = lectureId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public LocalDate getLectureDate() {
        return lectureDate;
    }

    public void setLectureDate(LocalDate lectureDate) {
        this.lectureDate = lectureDate;
    }

    public LocalTime getLectureTime() {
        return lectureTime;
    }

    public void setLectureTime(LocalTime lectureTime) {
        this.lectureTime = lectureTime;
    }
}
