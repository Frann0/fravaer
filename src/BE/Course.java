package BE;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;


public class Course {
    private String name;
    private List<User> students;
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
    public Course(String name, List<User> students, List<Subject> subjects) {
        setName(name);
        this.students = students;
        this.subjects = subjects;
        subjects.forEach(s -> {
            teachers.addAll(s.getTeachers());
            s.getLectures().keySet().forEach(l -> lectures.put(l, s.getLectures().get(l)));
        });
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<User> getStudents() {
        return students;
    }

    public List<User> getTeachers() {
        return teachers;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void printCourseTimes() {
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
            System.out.printf("%-10s %02d:%02d:%02d - %02d:%02d:%02d %5s %5s %n",
                    startTime.getDayOfWeek(),
                    startTime.getHour(), startTime.getMinute(),
                    startTime.getSecond(),
                    lectures.get(startTime).getHour(),
                    lectures.get(startTime).getMinute(),
                    lectures.get(startTime).getSecond(),
                    subjectName.get(),
                    name);
        });
    }
}
