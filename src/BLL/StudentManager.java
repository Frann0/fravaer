package BLL;

import BE.Lecture;
import BE.User;
import DAL.DB.UserDAL;

import java.util.List;

public class StudentManager {
    UserDAL userDAL = new UserDAL();


    public List<User> getUsers() {
        return userDAL.getUsers();
    }

    public List<Lecture> getLectures() {
        return userDAL.getLectures();
    }

    public int[][] getAttendances(){
        return userDAL.getAttendances();
    }
}
