package BE;


import java.time.Duration;
import java.time.LocalDateTime;

public class Lecture {
    private int lectureId;
    private String subjectName;
    private LocalDateTime lectureDate;
    private Duration lectureDuration;

    public Lecture() {
    }

    public Lecture(int lectureId, String subjectName, LocalDateTime lectureDate, Duration lectureDuration){
        this.lectureId = lectureId;
        this.subjectName = subjectName;
        this.lectureDate = lectureDate;
        this.lectureDuration = lectureDuration;
    }

    public Lecture(LocalDateTime date) {
        this.lectureDate = date;
    }

    public Lecture(String subject) {
        this.subjectName = subject;
    }

    public Lecture(String subjectName, LocalDateTime date) {
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

    public LocalDateTime getDate() {
        return lectureDate;
    }

    public void setDate(LocalDateTime lectureDate) {
        this.lectureDate = lectureDate;
    }

    public Duration getLectureDuration() {
        return lectureDuration;
    }

    public void setLectureDuration(Duration lectureDuration) {
        this.lectureDuration = lectureDuration;
    }
}
