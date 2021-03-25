package BE;

import java.util.List;

public class Subject {
    String name;
    List<User> users;

    public Subject() {
    }

    public Subject(String name) {
        this.name = name;
    }

    public Subject(List<User> users) {
        this.users = users;
    }

    public Subject(String name, List<User> users) {
        this.name = name;
        this.users = users;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}

