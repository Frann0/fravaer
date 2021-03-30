package BE;

import java.util.*;

public class User {
    private int id;
    private UserRole role;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
<<<<<<< Updated upstream
    private List<Subject> subjects;
=======
>>>>>>> Stashed changes

    public User() {
    }

    public User(UserRole role, String username, String password, String firstName, String lastName) {
        this.role = role;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.subjects = new ArrayList<>();
    }

    public User(int id, UserRole role, String username, String password, String firstName, String lastName) {
        this.id = id;
        this.role = role;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.subjects = new ArrayList<>();
    }

<<<<<<< Updated upstream
    public User(int id, UserRole role, String username, String password, String firstName, String lastName, List<Subject> subjects) {
=======
    public User(int id, UserRole role, String username, String password, String firstName, String lastName) {
>>>>>>> Stashed changes
        this.id = id;
        this.role = role;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
<<<<<<< Updated upstream
        this.subjects = subjects;
=======
>>>>>>> Stashed changes
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
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

<<<<<<< Updated upstream
    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }
=======
>>>>>>> Stashed changes
}

