package BE;

public class Attendance {
    private int id;
    private boolean isPresent;
    private Class attendanceClass;
    private User attendanceStudent;

    public Attendance(boolean isPresent, Class attendanceClass, User attendanceStudent) {
        setPresent(isPresent);
        setAttendanceClass(attendanceClass);
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

    public Class getAttendanceClass() {
        return attendanceClass;
    }

    public void setAttendanceClass(Class attendanceClass) {
        this.attendanceClass = attendanceClass;
    }

    public User getAttendanceStudent() {
        return attendanceStudent;
    }

    public void setAttendanceStudent(User attendanceStudent) {
        this.attendanceStudent = attendanceStudent;
    }
}
