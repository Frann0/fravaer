package BE;


import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.util.converter.LocalDateTimeStringConverter;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

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

    public Lecture(int lectureId, Subject subject, LocalDate lectureDate, LocalTime lectureTime) {
        this.lectureId = lectureId;
        this.subject = subject;
        this.lectureDate = LocalDateTime.of(lectureDate, lectureTime);
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
