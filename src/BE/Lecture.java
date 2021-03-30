package BE;

import java.time.Duration;
import java.time.LocalDateTime;

public class Lecture {
    private Subject subject;
    private LocalDateTime date;
    private Duration lectureDuration;

    public Lecture() {
    }

    public Lecture(LocalDateTime date) {
        this.date = date;
    }

    public Lecture(Subject subject) {
        this.subject = subject;
    }

    public Lecture(Subject subject, LocalDateTime date, Duration lectureDuration) {
        this.subject = subject;
        this.date = date;
        this.lectureDuration=lectureDuration;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Duration getLectureDuration() {
        return lectureDuration;
    }

    public void setLectureDuration(Duration lectureDuration) {
        this.lectureDuration = lectureDuration;
    }
}
