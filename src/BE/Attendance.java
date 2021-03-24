package BE;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicBoolean;

public class Attendance {
    private Student student;

    public Attendance(Student student) {
        this.student = student;
    }

    /**
     * Attempts to attend at the current date
     *
     * @throws Exception if the date is invalid
     */
    public boolean attendDate() {
        AtomicBoolean dateCheck = new AtomicBoolean(false);
        student.getSubjects().forEach(s -> {
            s.getLectures().forEach((t, t2) -> {
                        if (dateCheck(LocalDateTime.now(), s, t, t2))
                            dateCheck.set(true);
                    }
            );
        });
        return dateCheck.get();
    }

    /**
     * Attends the given subject at the given date
     */
    public boolean attendDate(LocalDateTime localDateTime) {
        AtomicBoolean dateCheck = new AtomicBoolean(false);
        student.getSubjects().forEach(s ->
                s.getLectures().forEach((t, t2) ->{
                        if(dateCheck(localDateTime, s, t, t2))
                            dateCheck.set(true);
                }
                ));
        return dateCheck.get();
    }

    /**
     * Checks the date is within the subject
     *
     * @param localDateTime the attended date
     * @param subject       the subject
     * @param t             early time limit
     * @param t2            late time limit
     */
    private boolean dateCheck(LocalDateTime localDateTime, Subject subject, LocalDateTime t, LocalDateTime t2) {
        //Checks attendance day
        if (localDateTime.getDayOfWeek() == t.getDayOfWeek() || localDateTime.getDayOfWeek() == t2.getDayOfWeek()) {
            //Checks if attendance is within the right hour
            if (localDateTime.getHour() > t.getHour() || localDateTime.getHour() < t2.getHour()) {
                attend(subject, localDateTime.toLocalDate());
                return true;
            }
            if (localDateTime.getHour() == t.getHour()) {
                //Checks if it is within the class given it is on the hour limit
                if (localDateTime.getMinute() > t.getMinute()) {
                    attend(subject, localDateTime.toLocalDate());
                    return true;
                }
            }
            if (localDateTime.getHour() == t2.getHour()) {
                //Checks if it is within the class given it is on the hour limit
                if (localDateTime.getMinute() < t2.getMinute()) {
                    attend(subject, localDateTime.toLocalDate());
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Attends a date
     *
     * @param subject the subject
     * @param d       the date you attend
     */
    private void attend(Subject subject, LocalDate d) {
        subject.getDates().add(d);
        student.getAttendedDates().add(d);
    }
}
