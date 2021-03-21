package BE;

public class Attendance{
    private Lecture lecture;
    private boolean attendance;

    public Attendance( Lecture lecture, boolean attended) {
        this.lecture = lecture;
        setPresent(attended);
    }

    public boolean getAttendance() {
        return attendance;
    }

    public void setPresent(boolean attendance) {
        this.attendance = attendance;
    }

}
