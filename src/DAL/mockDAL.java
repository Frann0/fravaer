package DAL;

import BE.DbCon;
import BE.User;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class mockDAL {
    private DbCon dbCon = new DbCon();
    ArrayList<User> users = new ArrayList<>();
    ArrayList<String> subjects = new ArrayList<>();
    ArrayList<User> dbUsers;


    public mockDAL() throws IOException {
        createUserArrayList(users);
        createSubjectsArrayList(subjects);
        dbUsers = getUsers();
    }



    public void addUsers() {

        try(Connection con = dbCon.getConnection()) {

            // Insert users into db
            PreparedStatement pSql = con.prepareStatement("INSERT INTO [User] VALUES(?,?,?,?,?)");
            for(User user : users){
                pSql.setString(1, user.getUsername());
                pSql.setString(2, user.getFirstName());
                pSql.setString(3, user.getLastName());
                pSql.setInt(4, user.getRole());
                pSql.setString(5, user.getPassword());
                pSql.addBatch();
            }
            pSql.executeBatch();

        } catch (SQLException throwables) {

        }
    }

    public void addSubjects(){

        try(Connection con = dbCon.getConnection()) {

            // Insert subjects into db(Subject)
            PreparedStatement pSql = con.prepareStatement("INSERT INTO Subject VALUES(?)");
            for(String str : subjects){
                pSql.setString(1, str);
                pSql.addBatch();
            }
            pSql.executeBatch();

        } catch (SQLException throwables) {
        }
    }

    public void createClasses(){

        try(Connection con = dbCon.getConnection()) {
            PreparedStatement pSql = con.prepareStatement("INSERT INTO Class VALUES(?,?)");

            for(String str : subjects){
                for(User user : dbUsers){
                    pSql.setString(1, str);
                    pSql.setInt(2, user.getId());
                    pSql.addBatch();
                }
            }
            pSql.executeBatch();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public ArrayList<User> getUsers(){
        ArrayList<User> users = new ArrayList<>();

        try(Connection con = dbCon.getConnection()) {
            String sqlString = "SELECT * FROM [User]";
            PreparedStatement pSql = con.prepareStatement(sqlString);
            pSql.execute();
            ResultSet resultSet = pSql.getResultSet();

            while (resultSet.next()){
                int id = resultSet.getInt("Id");
                int role = resultSet.getInt("Role");
                String userName = resultSet.getString("UserName");
                String firstName = resultSet.getString("FirstName");
                String lastName = resultSet.getString("LastName");
                String password = resultSet.getString("Password");
                User newUser = new User(id, role, userName, password, firstName, lastName);
                users.add(newUser);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return users;
    }

    public void initializeLectures() {
        // Create 5 lecture dates
        ArrayList<LocalDate> lectureDates = new ArrayList<>();
        for(int i = 1; i<6; i++){
            lectureDates.add(LocalDate.of(2021, 3, i));
        }


        try(Connection con = dbCon.getConnection()) {
            PreparedStatement pSql = con.prepareStatement("INSERT INTO Attendance VALUES(?,?,?,?)");
            int c = 1;

            for(LocalDate date : lectureDates){
                for(String subject : subjects){
                    for(User user : dbUsers){
                        if(user.getRole() == 1){
                            pSql.setString(1, subject);
                            pSql.setDate(2, Date.valueOf(date));
                            pSql.setInt(3, user.getId());
                            int i = c == 1 ? 1 : 2;
                            pSql.setInt(4, i);
                            pSql.addBatch();
                            if(c < 5){
                                c++;
                            } else {c = 1;}
                        }
                    }
                }
            }
            pSql.executeBatch();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    // TODO getClassAttendance

    // TODO getStudentAttendance
    public void getStudentAttendance(String username){


        // Return list of absent days

    }

    // TODO getAbsentDaysList
    public ArrayList<LocalDate> getAbsentDaysList(int userId) {
        ArrayList<LocalDate> absentDays = new ArrayList<>();

        try (Connection con = dbCon.getConnection()) {
            PreparedStatement pSql = con.prepareStatement("SELECT * FROM Attendance WHERE UserId = ?");
            pSql.setInt(1, userId);
            pSql.execute();

            ResultSet resultSet = pSql.getResultSet();

            while (resultSet.next()) {
                if(resultSet.getInt("Absent") == 1){
                    absentDays.add(resultSet.getDate("LectureDate").toLocalDate());
                }
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return absentDays;
    }


    private void createUserArrayList(ArrayList<User> users) {
        // Add students
        users.add(new User(1,"madsq","test","Mads","Qvistgaard"));
        users.add(new User(1,"svendh","test","Svend","Halding"));
        users.add(new User(1,"jonasb","test","Jonas","Buus"));
        users.add(new User(1,"mikeh","test","Mike","Hovedskov"));
        // Add teachers
        users.add(new User(2,"peters","test","Peter","Stegger"));
        users.add(new User(2,"jeppe","test","Jeppe","Led"));
    }
    private void createSubjectsArrayList(ArrayList<String> subjects) {
        subjects.add("SCO");
        subjects.add("SDE");
        subjects.add("DBO");
        subjects.add("ITO");
    }

    public static void main(String[] args) throws IOException {
        mockDAL myMockDAL = new mockDAL();

        // myMockDAL.addUsers();
        // myMockDAL.addSubjects();
        // myMockDAL.createClasses();
        // myMockDAL.initializeLectures();



        ArrayList<LocalDate> absentDays = myMockDAL.getAbsentDaysList(2);
        for(LocalDate date : absentDays){
            System.out.println(date);
        }


    }
}
