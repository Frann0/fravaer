package BE;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

public class User {
    private int id;
    private UserRole role;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private Set<Course> courses = new HashSet<>();
    private Set<Subject> subjects = new HashSet<>();

    public User(UserRole role, String username, String password, String firstName, String lastName) {
        setRole(role);
        setUsername(username);
        setPassword(password);
        setFirstName(firstName);
        setLastName(lastName);
    }

    /**
     * Constructor
     *
     * @param role
     * @param username
     * @param password
     * @param firstName
     * @param lastName
     */
    public User(int id, UserRole role, String username, String password, String firstName, String lastName) {
        this.id = id;
        this.role = role;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Gets the id
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the id
     *
     * @param id the new id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the Role
     *
     * @return The Role of the User
     */
    public UserRole getRole() {
        return role;
    }

    /**
     * Sets the role
     *
     * @param role the Role
     */
    public void setRole(UserRole role) {
        this.role = role;
    }

    /**
     * Gets the username
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username
     *
     * @param username the new username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the password
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password
     *
     * @param password the new Password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the first name
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name
     *
     * @param lastName the new last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the list of subjects
     *
     * @return the subjects
     */
    public Set<Subject> getSubjects() {
        courses.forEach(course -> course.getSubjects().forEach(s -> {
            if (!subjects.contains(s))
                subjects.add(s);
        }));
        return subjects;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    /**
     * Gets the firstname and lastname as a string
     *
     * @return the first name and last name as a string
     */
    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

    /**
     * Prints the users subjects by day
     */
    public void printSubjects() {
        Map<LocalDateTime,LocalDateTime> lectures = new HashMap<>();
        getSubjects().forEach(s -> {
            s.getLectures().keySet().forEach(l -> lectures.put(l, s.getLectures().get(l)));
        });
        List<LocalDateTime> dateTimes = new ArrayList(lectures.keySet());
        Collections.sort(dateTimes, Comparator.comparingInt((LocalDateTime localDateTime) -> localDateTime.getDayOfWeek().getValue()*24+localDateTime.getHour()));
        dateTimes.forEach((startTime) -> {
            AtomicReference<String> subjectName = new AtomicReference<>("");
            subjects.forEach(s-> {
                if(s.getLectures().containsKey(startTime))
                    subjectName.set(s.getName());

            });
            System.out.printf("%-10s %02d:%02d - %02d:%02d  %-5s %n",
                    startTime.getDayOfWeek(),
                    startTime.getHour(),
                    startTime.getMinute(),
                    lectures.get(startTime).getHour(),
                    lectures.get(startTime).getMinute(),
                    subjectName.get());
        });
    }
}

