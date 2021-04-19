package BE;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class User {
    private int id;
    private UserRole role;
    private StringProperty username;
    private StringProperty password;
    private StringProperty firstName;
    private StringProperty lastName;


    public User() {
        initialize();
    }

    public User(UserRole role, String username, String password, String firstName, String lastName) {
        initialize();
        setRole(role);
        setUsername(username);
        setPassword(password);
        setFirstName(firstName);
        setLastName(lastName);
    }

    public User(int id, UserRole role, String username, String password, String firstName, String lastName) {
        initialize();
        setId(id);
        setRole(role);
        setUsername(username);
        setPassword(password);
        setFirstName(firstName);
        setLastName(lastName);

    }

    protected void initialize() {
        username = new SimpleStringProperty();
        password = new SimpleStringProperty();
        firstName = new SimpleStringProperty();
        lastName = new SimpleStringProperty();
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", role=" + role +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public String getUsername() {
        return username.get();
    }

    public StringProperty getUsernameProperty() {
        return username;
    }

    public void setUsername(String username) {
        this.username.set(username);
    }

    public StringProperty getPasswordProperty() {
        return password;
    }

    public String getPassword() {
        return password.get();
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    public StringProperty getFirstNameProperty() {
        return firstName;
    }

    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public StringProperty getLastNameProperty() {
        return lastName;
    }

    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }
}

