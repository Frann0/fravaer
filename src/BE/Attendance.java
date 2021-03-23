package BE;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Attendance {
    private int id;
    private Subject subject;
    private LocalDateTime attendDate;
    private boolean isPresent;
    private User user;

    /**
     * Makes a new attendance
     * @param user the student you want to attend
     */
    public Attendance(User user) {
        this.user=user;
        user.getSubjects().forEach(s ->
                s.getSubjectTimes().forEach((t, t2) ->
                        dateCheck(LocalDateTime.now(), s, t, t2)
                ));
    }

    /**
     * Makes a new attendance at the given date
     * @param user the student you want to attend
     * @param localDateTime the date the student attends
     */
    public Attendance(User user, LocalDateTime localDateTime) {
        this.user=user;
        user.getSubjects().forEach(s ->
                s.getSubjectTimes().forEach((t, t2) ->
                        dateCheck(localDateTime, s, t, t2)
                ));
    }

    /**
     * Checks the date is within the subject
     * @param localDateTime the attended date
     * @param subject the subject
     * @param t early time limit
     * @param t2 late time limit
     * @return if the date is viable
     */
    private void dateCheck(LocalDateTime localDateTime, Subject subject, LocalDateTime t, LocalDateTime t2) {
        attendDate = localDateTime;
        //Checks attendance day
        if (attendDate.getDayOfWeek() == t.getDayOfWeek()) {
            //Checks if attendance is within the right hour
            if (attendDate.getHour() > t.getHour() && attendDate.getHour() < t2.getHour()) {
                attend(subject,attendDate.toLocalDate());
            }
            else if (attendDate.getHour() == t.getHour()) {
                //Checks if it is within the class given it is on the hour limit
                if(attendDate.getMinute()>t.getMinute()){
                    attend(subject,attendDate.toLocalDate());
                }
            }
            else if(attendDate.getHour() == t2.getHour()){
                //Checks if it is within the class given it is on the hour limit
                if(attendDate.getMinute()<t2.getMinute()){
                    attend(subject,attendDate.toLocalDate());
                }
            }
        }
    }

    /**
     * Attends a date
     * @param subject the subject
     * @param d the date you attend
     */
    private void attend(Subject subject, LocalDate d) {
        this.subject = subject;
        this.subject.getDates().add(d);
        user.getAttendedDates().add(d);
        this.isPresent = true;
    }

    /**
     * Gets the id
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the id
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Confirmation on whether or not the user has attended
     * @return true if has attended false otherwise
     */
    public boolean isPresent() {
        return isPresent;
    }

    /**
     * Changes the is preset variable
     * @param present the new value
     */
    public void setPresent(boolean present) {
        isPresent = present;
    }

    /**
     * Gets the subject
     * @return the subject that has been attended to
     */
    public Subject getAttendanceClass() {
        return subject;
    }

    public Subject getSubject() {
        return subject;
    }

    /**
     * Sets the subject
     * @param newSubject the subject
     */
    public void setSubject(Subject newSubject) {
        this.subject = newSubject;
    }

    /**
     * Gets the student
     * @return the student
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the student
     * @param user the new student
     */
    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getAttendDate() {
        return attendDate;
    }
}
