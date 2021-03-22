package BE;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class Subject {
    private int id;
    private String name;
    private List<User> enrolledStudents = new ArrayList<>();
    private Map<LocalDateTime, LocalDateTime> subjectTimes = new HashMap<>();
    private Set<LocalDate> attendances = new HashSet<>();

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
    public Map<LocalDateTime, LocalDateTime> getSubjectTimes() {
        return subjectTimes;
    }


    @Override
    public String toString() {
        return getName();
    }

    public Set<LocalDate> getDates(){
        return attendances;
    }

    public void printSubjectTimes() {
            subjectTimes.keySet().forEach((s) -> {
                    System.out.printf("%s %d/%d-%d %02d:%02d:%02d - %02d:%02d:%02d - %s %n",
                            s.getDayOfWeek(),s.getDayOfMonth(),
                            s.getMonthValue(),
                            s.getYear(),
                            s.getHour(), s.getMinute(),
                            s.getSecond(),
                            subjectTimes.get(s).getHour(),
                            subjectTimes.get(s).getMinute(),
                            subjectTimes.get(s).getSecond(),
                            name);
            });
        }
    }

