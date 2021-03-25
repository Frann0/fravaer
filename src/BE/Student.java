package BE;

import java.util.List;

public class Student extends User{

    public Student() {
    }

    public Student(int id, UserRole role, String username, String password, String firstName, String lastName) {
        super(role, username, password, firstName, lastName);
    }

    public Student(int id, UserRole role, String username, String password, String firstName, String lastName, List<Attendance> attendances) {
        super(id, role, username, password, firstName, lastName, attendances);
    }
}
