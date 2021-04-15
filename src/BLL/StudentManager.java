package BLL;

import BE.Lecture;
import BE.Subject;
import BE.User;
import DAL.DB.UserDAL;

import java.util.List;

public class StudentManager {
    UserDAL userDAL = new UserDAL();

    /**
     * Get all users.
     *
     * @return Returns a list of all users.
     */
    public List<User> getUsers() {
        return userDAL.getUsers();
    }

    /**
     * Get all lectures.
     *
     * @return Returns a list of all lectures.
     */
    public List<Lecture> getLectures() {
        return userDAL.getLectures();
    }

    /**
     * Get all attendances.
     *
     * @return Returns a list of all attendances.
     */
    public int[][] getAttendances() {
        return userDAL.getAttendances();
    }

    /**
     * Get all subjects.
     *
     * @return Returns a list of all subjects.
     */
    public List<Subject> getSubjects() {
        return userDAL.getSubjects();
    }
}
