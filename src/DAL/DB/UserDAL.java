package DAL.DB;

import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 * Author: Jonas Buus Nielsen
 * Version: 1.0
 */

public class UserDAL {
    private DbConnectionHandler dbCon = DbConnectionHandler.getInstance();

    public UserDAL() throws IOException {
    }

    /**
     * Add user to database
     *
     * @param firstName
     * @param lastName
     * @param password
     * @param role      0 = teacher , 1 = student
     */
    public void addUser(String firstName, String lastName, String password, int role) {

        try (Connection con = dbCon.getConnection()) {

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


    public void example() {


    }

    public static void main(String[] args) throws IOException {
        UserDAL userDAL = new UserDAL();

        //userDAL.addUser("Jeppe", "Led", "test", 0);


    }


}
