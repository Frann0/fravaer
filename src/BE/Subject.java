package BE;

import java.util.List;

public class Subject {
    private String name;
    private List<User> teachers;

    public Subject(){};

    public Subject(String name, List<User> teachers){
        this.name = name;
        this.teachers = teachers;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addTeachers(User teacher) {
        this.teachers.add(teacher);
    }

    public void removeTeacher(User teacher){
        this.teachers.remove(teacher);
    }
}
