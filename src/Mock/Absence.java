package Mock;

import java.time.LocalDate;

public class Absence {
    private String subjectName;
    private LocalDate lectureDate;
    private boolean absent;

    public Absence(String subjectName, LocalDate lectureDate, boolean absent){
        this.subjectName = subjectName;
        this.lectureDate = lectureDate;
        this.absent = absent;
    }

    public LocalDate getLectureDate() {
        return lectureDate;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public boolean getAbsent(){
        return absent;
    }
}
