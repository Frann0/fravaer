package BE;

import java.util.ArrayList;
import java.util.List;


public class Class extends Subject{
    private String name;
    private List<User> students;
    private List<Lecture> lectures;

    public Class(String name) {
        setName(name);
        this.students = new ArrayList<>();
        this.lectures = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addStudent(User student){
        students.add(student);
    }

    public void removeStudent(User student){
        students.remove(student);
    }

    public void addTeacher(User teacher){
        students.add(teacher);
    }

    public void removeTeacher(User teacher){
        students.remove(teacher);
    }

    @Override
    public String toString() {
        return getName();
    }
}
