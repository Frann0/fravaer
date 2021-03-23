package DAL.DB;


import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Author: Jonas Buus Nielsen
 * Version: 1.0
 */
public class LectureDAL {
    private DbTempCon dbCon = new DbTempCon();

    public LectureDAL() throws IOException {
    }



    /**
     * Add lecture to database
     *
     * @param subjectId must be an existing subject in the db.
     * @param lectureDate Starting time for the lecture,
     *                    format: Date(int year, int month, int date, int hrs, int min)
     */
    public void addLecture(int subjectId, LocalDate lectureDate, LocalTime lectureTime) {

        try (Connection con = dbCon.getConnection()) {

            PreparedStatement pSql = con.prepareStatement("INSERT INTO Lecture VALUES(?,?,?)");
            pSql.setInt(1, subjectId);
            pSql.setDate(2, Date.valueOf(lectureDate));
            pSql.setTime(3, Time.valueOf(lectureTime));

            pSql.execute();

        } catch (SQLServerException throwables) {
            throwables.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void setAttendance(int userId, int lectureId, boolean attended){



    }

}
