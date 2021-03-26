package DAL.DB;

import BE.Attendance;
import BE.Lecture;
import BE.User;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * TEMPORARY CLASS FOR DATA GENERATION
 */

public class DataGenerator {

    private final int LECTURE_DURATION = 45;
    private static List<Lecture> allLectures = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        LectureDAL lectureDAL = new LectureDAL();








        //addLectures(lectureDAL);
        //setAttendance(lectureDAL);

    }



    public void registerAttendance(User student, LocalDateTime registration){

        LocalDate registrationDate = registration.toLocalDate();
        LocalTime registrationTime = registration.toLocalTime();

        for(Lecture lecture : allLectures){

            if(lecture.getLectureDate().equals(registrationDate) &&
            registrationTime.isAfter(lecture.getLectureTime()) &&
            registrationTime.isBefore(lecture.getLectureTime().plusMinutes(LECTURE_DURATION))){

                student.addAttendance(new Attendance(lecture, true));

            }
        }
    }






    private static void setAttendance(LectureDAL lectureDAL) {
        

    }

    private static void addLectures(LectureDAL lectureDAL) {
        LocalTime lectureTime = LocalTime.of(11,0);

        for(int i = 0; i<28; i++){
            lectureDAL.addLecture(4, LocalDate.of(2021,4,i+1), lectureTime);
        }
    }
}
