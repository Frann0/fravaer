package BE;

import java.time.LocalDate;

public class Lecture {
    private String subjectName;
    private LocalDate lectureDate;

    public Lecture(String subjectName, LocalDate lectureDate){
        this.subjectName = subjectName;
        this.lectureDate = lectureDate;
    }

}
