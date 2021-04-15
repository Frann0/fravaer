package BE;


import java.time.Duration;
import java.time.LocalDateTime;

public class Lecture {
    private int lectureId;
    private LocalDateTime lectureDate;
    private Duration lectureDuration;
    private Subject subject;

    public Lecture() {
    }

    public Lecture(int lectureId, Subject subject, LocalDateTime lectureDate, Duration lectureDuration) {
        setLectureId(lectureId);
        setSubject(subject);
        setLectureDate(lectureDate);
        setLectureDuration(lectureDuration);
    }

    public Lecture(LocalDateTime date) {
        this.lectureDate = date;
    }

    public Lecture(Subject subject) {
        setSubject(subject);
    }

    public Lecture(Subject subject, LocalDateTime date) {
        setSubject(subject);
        setLectureDate(date);
    }

    public Lecture(int lectureId, Subject subject, LocalDateTime lecture) {
        setLectureId(lectureId);
        setSubject(subject);
        setLectureDate(lectureDate);
    }

    public int getLectureId() {
        return lectureId;
    }

    public void setLectureId(int lectureId) {
        this.lectureId = lectureId;
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

    @Override
    public String toString() {
        return "Lecture{" +
                "lectureId=" + lectureId +
                ", subjectName='" + getSubject().getName() + '\'' +
                ", lectureDate=" + lectureDate +
                ", lectureDuration=" + lectureDuration +
                '}';
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public LocalDateTime getLectureDate() {
        return lectureDate;
    }

    public void setLectureDate(LocalDateTime lectureDate) {
        this.lectureDate = lectureDate;
    }
}
