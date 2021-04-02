package BLL;

import BE.Attendance;
import BE.Lecture;
import BE.Student;
import DAL.DB.UserDAL;

public class AttendanceManager {

    // TODO create all...

    /**
     * Updates the student's attendance at the given lecture
     * @param student the student you want to update
     * @param lecture the lecture you want the student to register to
     */
    public static void updateStudentAttendance(Student student, Lecture lecture) {
        UserDAL userDAL = new UserDAL();
        student.getAttendances().add(new Attendance(lecture, true));
        userDAL.addAttendanceRegistration(student.getId(),lecture.getLectureId());
    }

}
