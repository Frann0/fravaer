package BE;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Attendance {
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
     */
    private void dateCheck(LocalDateTime localDateTime, Subject subject, LocalDateTime t, LocalDateTime t2) {
        //Checks attendance day
        if (localDateTime.getDayOfWeek() == t.getDayOfWeek()) {
            //Checks if attendance is within the right hour
            if (localDateTime.getHour() > t.getHour() && localDateTime.getHour() < t2.getHour()) {
                attend(subject, localDateTime.toLocalDate());
            }
            else if (localDateTime.getHour() == t.getHour()) {
                //Checks if it is within the class given it is on the hour limit
                if(localDateTime.getMinute()>t.getMinute()){
                    attend(subject, localDateTime.toLocalDate());
                }
            }
            else if(localDateTime.getHour() == t2.getHour()){
                //Checks if it is within the class given it is on the hour limit
                if(localDateTime.getMinute()<t2.getMinute()){
                    attend(subject, localDateTime.toLocalDate());
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
    }
}
