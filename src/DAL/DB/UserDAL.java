package DAL.DB;

import BE.User;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * Author: Jonas Buus Nielsen
 * Version: 1.0
 */

public class UserDAL {
    private DbTempCon dbCon = new DbTempCon();

    public UserDAL() throws IOException {
    }

    /**
     * Add user to database
     * @param firstName
     * @param lastName
     * @param password
     * @param role  0 = teacher , 1 = student
     */
    public void addUser(String firstName, String lastName, String password, int role){

        try(Connection con = dbCon.getConnection()){

            PreparedStatement pSql = con.prepareStatement("INSERT INTO [User] VALUES(?,?,?,?)");
            pSql.setString(1, firstName);
            pSql.setString(2, lastName);
            pSql.setString(3, password);
            pSql.setInt(4, role);

            pSql.execute();

        } catch (SQLServerException throwables) {
            throwables.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }


    public List<User> getUsers()  {
        List<User> allUsers = new ArrayList<>();

        try(Connection con = dbCon.getConnection()){

            // allUsers.addAll(getUsersFromDb());

            // addSubject(); join class + subject, add subjectname to user

            // 

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return allUsers;
    }

}
