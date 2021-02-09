package BE;

import java.util.ArrayList;

public class User {
    private int id;
    private int role;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private ArrayList<Subject> subjects;

    public User(int role, String username, String password, String firstName, String lastName) {
        setRole(role);
        setUsername(username);
        setPassword(password);
        setFirstName(firstName);
        setLastName(lastName);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public ArrayList<Subject> getSubjects() {
        return subjects;
    }

    public void addSubject(Subject c) {
        subjects.add(c);
    }

    public void addSubjects(ArrayList<Subject> c) {
        subjects.addAll(c);
    }

    public void removeSubject(Subject c) {
        subjects.remove(c);
    }

    public void removeSubjects(ArrayList<Subject> c) {
        subjects.removeAll(c);
    }
}
