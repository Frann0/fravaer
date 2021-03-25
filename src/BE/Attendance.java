package BE;

public class Attendance {
    private Lecture lecture;
    private boolean attended;

    public Attendance() {
    }

    public Attendance(Lecture lecture) {
        this.lecture = lecture;
    }

    public Attendance(Lecture lecture, boolean attended) {
        this.lecture = lecture;
        this.attended = attended;
    }

    public Lecture getLecture() {
        return lecture;
    }

    public void setLecture(Lecture lecture) {
        this.lecture = lecture;
    }

    public boolean isAttended() {
        return attended;
    }

    public void setAttended(boolean attended) {
        this.attended = attended;
    }
}
