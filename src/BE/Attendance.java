package BE;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Attendance {
    private int id;
    private LocalDateTime attendDate;
    Map<LocalDate, Boolean> attendance = new HashMap<>();
    private Student student;

    public Attendance(Student student){
        this.student=student;
    }

    /**
     * Attempts to attend at the current date
     * @throws Exception if the date is invalid
     */
    public void attendDate(){
        student.getSubjects().forEach(s ->
                s.getLectures().forEach((t, t2) ->
                        dateCheck(LocalDateTime.now(), s, t, t2)
                ));
    }

    /**
     * Attends the given subject at the given date
     */
    public void attendDate(LocalDateTime localDateTime) {
            student.getSubjects().forEach(s ->
                    s.getLectures().forEach((t, t2) ->
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
        subject.getDates().add(d);
        student.getAttendedDates().add(d);
        attendance.put(d,true);
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
    public boolean isPresent(LocalDate localDate) {
        return attendance.get(localDate);
    }

    /**
     * Changes the is preset variable
     * @param present the new value
     */
    public void setPresent(LocalDate localDate,boolean present) {
        attendance.put(localDate,present);
    }

    /**
     * Gets the student
     * @return the student
     */
    public User getStudent() {
        return student;
    }

    /**
     * Sets the student
     * @param student the new student
     */
    public void setStudent(Student student) {
        this.student=student;
    }

    public LocalDateTime getAttendDate() {
        return attendDate;
    }
}
