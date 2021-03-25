package BE;

import java.time.LocalDate;

public class Lecture {
    private Subject subject;
    private LocalDate date;

    public Lecture() {
    }

    public Lecture(LocalDate date) {
        this.date = date;
    }

    public Lecture(Subject subject) {
        this.subject = subject;
    }

    public Lecture(Subject subject, LocalDate date) {
        this.subject = subject;
        this.date = date;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
