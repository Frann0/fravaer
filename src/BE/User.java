package BE;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int id;
    private int role;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private List<Attendance> attendance;
    private List<Subject> subjects;


    public User(int role, String username, String password, String firstName, String lastName) {
        setRole(role);
        setUsername(username);
        setPassword(password);
        setFirstName(firstName);
        setLastName(lastName);
        attendance = new ArrayList<>();
    }

    public User(int id, int role, String username, String password, String firstName, String lastName) {
        setId(id);
        setRole(role);
        setUsername(username);
        setPassword(password);
        setFirstName(firstName);
        setLastName(lastName);

        attendance = new ArrayList<>();
    }

    public User(int id, int role, String username, String password, String firstName, String lastName, List<Attendance> attendance, List<Subject> subjects) {
        this.id = id;
        this.role = role;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.attendance = attendance;
        this.subjects = subjects;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Attendance> getAttendance() {
        return attendance;
    }

    public void addAttendance(Attendance lecture){
        this.attendance.add(lecture);
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
