package BE;

import java.util.ArrayList;
import java.util.List;

public class Student extends User{
    private List<Attendance> attendance;

    public Student() {
    }

    public Student(int id, UserRole role, String username, String password, String firstName, String lastName) {
        super(id, role, username, password, firstName, lastName);
        attendance = new ArrayList<>();
    }

    public Student(int id, UserRole role, String username, String password, String firstName, String lastName, List<Attendance> attendance) {
        super(id, role, username, password, firstName, lastName);
        this.attendance = attendance;
    }
}
