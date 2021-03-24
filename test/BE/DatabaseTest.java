package BE;

import DAL.DB.DbConnectionHandler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLNonTransientConnectionException;
import java.sql.Statement;

public class DatabaseTest {

    @DisplayName("Connection Test")
    @Test
    public void ConnectionTest() throws SQLException {
        var db = DbConnectionHandler.getInstance();
        Assertions.assertNotNull(db.getConnection());
    }

    @DisplayName("Query Test")
    @Test
    public void QueryTest() {
        var db = DbConnectionHandler.getInstance();
        var sql = "SELECT * FROM playlist WHERE playlist_name = ?;";

        // Act + assert
        Exception connectionException = Assertions.assertThrows(SQLNonTransientConnectionException.class, () -> {
            var con = db.getConnection();
            PreparedStatement st = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            st.setString(1, "Test");
            st.executeQuery();
        });
    }
}
