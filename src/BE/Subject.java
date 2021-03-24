package BE;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class Subject {
    private int id;
    private String name;
    private List<User> students = new ArrayList<>();
    private List<User> teachers = new ArrayList<>();
    private Set<LocalDate> attendances = new HashSet<>();
    private Map<LocalDateTime, LocalDateTime> lectures = new HashMap<>();

    /**
     * The name of the subject
     * @param name the name
     */
    public Subject(String name) {
        this.name = name;
    }

    /**
     * Gets the subject id
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the subject id
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the subject name
     * @return the subject name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the subject name
     * @param name the new subject name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the map of subject times, with the first time being the early limiter,
     * and the last time being the late limiter.
     * @return A map of subject times
     */
    public Map<LocalDateTime, LocalDateTime> getLectures() {
        return lectures;
    }

    /**
     * Gets a list of Students assigned to this subject
     * @return a list of students assigned to this subject.
     */
    public List<User> getStudents() {
        return students;
    }

    /**
     * Gets a list of teachers, teaching this subject.
     * @return a list of teachers, teaching this subject.
     */
    public List<User> getTeachers() {
        return teachers;
    }

    /**
     * TODO Er det her rigtigt forstået?
     * Gets a set of dates which the Subject is being held on.
     * @return a set of dates which the Subject is being held on.
     */
    public Set<LocalDate> getDates(){
        return attendances;
    }

    public void printSubjectLectures() {
        List<LocalDateTime> dateTimes = new ArrayList<LocalDateTime>(lectures.keySet());
        dateTimes.sort(Comparator.comparingInt((LocalDateTime localDateTime) -> localDateTime.getDayOfWeek().getValue()));
            dateTimes.forEach((s) -> {
                    System.out.printf("%-10s %02d:%02d - %02d:%02d  %-5s %n",
                            s.getDayOfWeek(),
                            s.getHour(),
                            s.getMinute(),
                            lectures.get(s).getHour(),
                            lectures.get(s).getMinute(),
                            name);
            });
    }
    }

