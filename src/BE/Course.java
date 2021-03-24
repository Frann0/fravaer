package BE;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;


public class Course {
    private int id;
    private String name;
    private List<Student> students;
    private List<User> teachers = new ArrayList<>();
    private Map<LocalDateTime, LocalDateTime> lectures = new HashMap<>();
    private List<Subject> subjects;

    /**
     * Constructor
     *
     * @param name     the name of the course
     * @param students The students enrolled
     * @param subjects the subjects of the course
     */
    public Course(String name, List<Student> students, List<Subject> subjects) {
        setName(name);
        this.students = students;
        this.subjects = subjects;
        subjects.forEach(s -> {
            teachers.addAll(s.getTeachers());
            s.getLectures().keySet().forEach(l -> lectures.put(l, s.getLectures().get(l)));
        });
    }

    /**
     * Constructor
     *
     * @param name     the name of the course
     * @param students The students enrolled
     * @param subjects the subjects of the course
     */
    public Course(int id,String name, List<Student> students, List<Subject> subjects) {
        this.id=id;
        setName(name);
        this.students = students;
        this.subjects = subjects;
        subjects.forEach(s -> {
            teachers.addAll(s.getTeachers());
            s.getLectures().keySet().forEach(l -> lectures.put(l, s.getLectures().get(l)));
        });
    }

    /**
     * Gets the courses ID
     * @return the id of the course
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the courses ID.
     * @param id the specified ID.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Sets the name of the course.
     * @param name the given name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the current name of the course.
     * @return the name of the course
     */
    public String getName() {
        return name;
    }

    /**
     * Gets a list of Students attending the course.
     * @return a list of students attending the course.
     */
    public List<Student> getStudents() {
        return students;
    }

    /**
     * Gets the teachers assigned to this course.
     * @return a list of teachers assigned to this course.
     */
    public List<User> getTeachers() {
        return teachers;
    }

    /**
     * Gets the subjects assigned to this course.
     * @return a list of subjects assigned to this course.
     */
    public List<Subject> getSubjects() {
        return subjects;
    }


    public void printCourseLectures() {
        subjects.forEach(s -> {
            s.getLectures().keySet().forEach(l -> lectures.put(l, s.getLectures().get(l)));
        });
        List<LocalDateTime> dateTimes = new ArrayList(lectures.keySet());
        Collections.sort(dateTimes, Comparator.comparingInt((LocalDateTime localDateTime) -> localDateTime.getDayOfWeek().getValue()*24+localDateTime.getHour()));
        dateTimes.forEach((startTime) -> {
            AtomicReference<String> subjectName = new AtomicReference<>(name);
            subjects.forEach(s-> {
                if(s.getLectures().containsKey(startTime))
                    subjectName.set(s.getName());

        });
            System.out.printf("%-10s %02d:%02d - %02d:%02d:%02d %5s %5s %n",
                    startTime.getDayOfWeek(),
                    startTime.getHour(),
                    startTime.getMinute(),
                    lectures.get(startTime).getHour(),
                    lectures.get(startTime).getMinute(),
                    lectures.get(startTime).getSecond(),
                    subjectName.get(),
                    name);
        });
    }
}
