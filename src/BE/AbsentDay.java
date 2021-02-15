package BE;

import java.time.LocalDate;

public class AbsentDay {
    private LocalDate date;
    private String subject;

    public AbsentDay(){

    }

    public LocalDate getDate() {
        return date;
    }

    public String getSubject() {
        return subject;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
