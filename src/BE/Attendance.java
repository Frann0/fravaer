package BE;

public class Attendance {
    private int id;
    private boolean isPresent;
    private Subject attendanceSubject;
    private User attendanceStudent;

    public Attendance(boolean isPresent, Subject attendanceSubject, User attendanceStudent) {
        setPresent(isPresent);
        setAttendanceClass(attendanceSubject);
        setAttendanceStudent(attendanceStudent);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isPresent() {
        return isPresent;
    }

    public void setPresent(boolean present) {
        isPresent = present;
    }

    public Subject getAttendanceClass() {
        return attendanceSubject;
    }

    public void setAttendanceClass(Subject attendanceSubject) {
        this.attendanceSubject = attendanceSubject;
    }

    public User getAttendanceStudent() {
        return attendanceStudent;
    }

    public void setAttendanceStudent(User attendanceStudent) {
        this.attendanceStudent = attendanceStudent;
    }
}
