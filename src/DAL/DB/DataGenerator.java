package DAL.DB;

import BE.*;
import GUI.MODEL.StudentModel;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 * TEMPORARY CLASS FOR DATA GENERATION
 */

public class DataGenerator {

    public static void main(String[] args) throws IOException {
        LectureDAL lectureDAL = new LectureDAL();
        StudentModel studentModel = StudentModel.getInstance();
        UserDAL userDAL = new UserDAL();

        int[][] att = userDAL.getAttendances();








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
