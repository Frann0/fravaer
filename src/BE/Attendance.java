package BE;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicBoolean;

public class Attendance {
    private Student student;
    /**
     * Some buffer before and after each lecture where the student has the extra buffer to attend.
     */
    private static final int minuteBuffer = 15;

    public Attendance(Student student) {
        this.student = student;
    }

    /**
     * Loops through the student's subjects, and makes sure that the student has lectures at the given time
     * @return whether or not the attendance attempt was successful
     */
    public boolean attendDate() {
        //Atomic boolean because variables in for each loops have to be effectively final
        AtomicBoolean dateCheck = new AtomicBoolean(false);
        //Get students subjects and loop through them
        student.getSubjects().forEach(s -> {
            //Check the lectures in the subjects for matches on the current time
            //Since the lectures are maps we can use lambda on the keyset and the resultset which it does automatically
            s.getLectures().forEach((startTime, endTime) -> {
                        if (dateCheck(LocalDateTime.now(), s, startTime.minusMinutes(minuteBuffer), endTime.plusMinutes(minuteBuffer))){
                            //Flips the boolean if the attendance was valid
                            dateCheck.set(true);
                        }
                    }
            );
        });
        //Returns whether or not the check was successful
        return dateCheck.get();
    }

    /**
     *
     * Attends the given subject at the given date
     * Basically does the same as the above, but instead of taking the current time, it attends at the
     * @param localDateTime
     * and
     * @return s whether or not the attempt was successful
     * if you want to see line by line check above
     */
    public boolean attendDate(LocalDateTime localDateTime) {
        AtomicBoolean dateCheck = new AtomicBoolean(false);
        student.getSubjects().forEach(s ->
                s.getLectures().forEach((startTime, endTime) ->{
                        if(dateCheck(localDateTime, s, startTime.minusMinutes(minuteBuffer), endTime.plusMinutes(minuteBuffer)))
                            dateCheck.set(true);
                }
                ));
        return dateCheck.get();
    }

    /**
     * Checks that the dateTimeToCheck is within the time limit of the lecture. If the dateTimeToCheck is valid it returns true, otherwise it returns false
     * If the date time is valid it will also attend the date.
     * @param dateTimeToCheck   the time you want to make sure is within a lecture
     * @param subject           the subject you are checking, and attending given the dateTimeToCheck is valid
     * @param startTime         the startTime of the lecture
     * @param endTime           the endTime of the lecture
     * @return                  If the dateTimeToCheck is valid
     */
    private boolean dateCheck(LocalDateTime dateTimeToCheck, Subject subject, LocalDateTime startTime, LocalDateTime endTime) {
        //Checks that the dateTimeToCheck is within the day constraints of the lecture
        if (dateTimeToCheck.getDayOfWeek() == startTime.getDayOfWeek() || dateTimeToCheck.getDayOfWeek() == endTime.getDayOfWeek()) {
            //Checks if the dateTimeToCheck is within the hourly constraint of the lecture
            if (dateTimeToCheck.getHour() > startTime.getHour() && dateTimeToCheck.getHour() < endTime.getHour()) {
                //The attendance is valid so we attend and return true!
                attend(subject, dateTimeToCheck.toLocalDate());
                return true;
            }
            //Checks if the of the dateTimeToCheck hour is equal to the start time, if it is we need to check whether or not it is within the minute limit
            if (dateTimeToCheck.getHour() == startTime.getHour()) {
                //Checks if the dateTimeToCheck is within the minute limit of the startTime
                if (dateTimeToCheck.getMinute() > startTime.getMinute()) {
                    //The attendance is valid so we attend and return true!
                    attend(subject, dateTimeToCheck.toLocalDate());
                    return true;
                }
            }
            //Checks if the of the dateTimeToCheck hour is equal to the end time, if it is we need to check whether or not it is within the minute limit
            if (dateTimeToCheck.getHour() == endTime.getHour()) {
                //Checks if the dateTimeToCheck is within the minute limit of the endTime
                if (dateTimeToCheck.getMinute() < Math.max(startTime.getMinute(),endTime.getMinute())) {
                    //The attendance is valid so we attend and return true!
                    attend(subject, dateTimeToCheck.toLocalDate());
                    return true;
                }
            }
        }
        //The dateTimeToCheck is not within the time constraints, så we return false.
        return false;
    }

    /**
     * Adds a dateToAttend to the subject's attended dates and Adds a dateToAttend to the student's attended dates.
     *
     * @param subject the subject you attend
     * @param dateToAttend       the dateToAttend you attend
     */
    private void attend(Subject subject, LocalDate dateToAttend) {
        subject.getDates().add(dateToAttend);
        student.getAttendedDates().add(dateToAttend);
    }
}
