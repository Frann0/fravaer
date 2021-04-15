package BE;

import java.util.List;

public class Subject {
    private int id;
    private String name;
    private List<User> users;

    public Subject() {
    }


    public Subject(int id, String name) {
        setId(id);
        setName(name);
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return getName();
    }

}

