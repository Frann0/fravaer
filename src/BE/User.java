package BE;

import Mock.Absence;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class User {
    private int id;
    private UserRole role;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private List<Subject> subjects = new ArrayList<>();
    private List<Attendance> attendance;
    private static List<LocalDate> allAttendedDates = new ArrayList<>();
    private Set<LocalDate> attendedDates = new HashSet<>();

    public User(UserRole role, String username, String password, String firstName, String lastName) {
        setRole(role);
        setUsername(username);
        setPassword(password);
        setFirstName(firstName);
        setLastName(lastName);
        this.subjects = new ArrayList<>();
        this.attendance = new ArrayList<>();
    }
    /**
     * Constructor
     * @param role
     * @param username
     * @param password
     * @param firstName
     * @param lastName
     */
    public User(int id, UserRole role, String username, String password, String firstName, String lastName, List<Attendance> attendance, List<Subject> subjects) {
        this.id = id;
        this.role = role;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.subjects = subjects;
        this.attendance = attendance;
    }

    /**
     * Gets the id
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the id
     * @param id the new id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the Role
     * @return The Role of the User
     */
    public UserRole getRole() {
        return role;
    }

    /**
     * Sets the role
     * @param role the Role
     */
    public void setRole(UserRole role) {
        this.role = role;
    }

    /**
     * Gets the username
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username
     * @param username the new username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the password
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password
     * @param password the new Password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the first name
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name
     * @param lastName the new last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the list of subjects
     * @return the subjects
     */
    public List<Subject> getSubjects() {
        return subjects;
    }

    /**
     * Gets the list of attended dates
     * @return the list of attended dates
     */
    public Set<LocalDate> getAttendedDates() {
        return attendedDates;
    }

    /**
     * Gets the list of attendances
     * @return the list of attendance
     */
    public List<Attendance> getAttendance() {
        return attendance;
    }

    public List<LocalDate> getAbsence(){
        List<LocalDate> absence = new ArrayList<>();
        this.subjects.forEach(s->{
            if(!attendedDates.containsAll(s.getDates())){
                s.getDates().forEach(
                        d->{
                            if(!attendedDates.contains(d))
                                absence.add(d);
                        }
                );
            }
        });
        return absence;
    }

    public List<LocalDate> getAbsence(Subject subject){
        List<LocalDate> absence = new ArrayList<>();
            if(!attendedDates.containsAll(subject.getDates())){
                subject.getDates().forEach(
                        d->{
                            if(!attendedDates.contains(d))
                                absence.add(d);
                        }
                );
            }
        return absence;
    }

    public List<LocalDate> getAttendedDates(Subject subject){
        List<LocalDate> subjectDates = new ArrayList<>();
        attendance.forEach(a->{
            if(a.getSubject()==subject&&a.isPresent())
                subjectDates.add(a.getAttendDate().toLocalDate());
        });
        return subjectDates;
    }

    public void getAbsentDates(){

    }

    /**
     * Gets the firstname and lastname as a string
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
        for (int i = 1; i < 6; i++) {
            int finalI = i;
            subjects.forEach(s2 -> s2.getSubjectTimes().keySet().forEach((s) -> {
                if (s.getDayOfWeek().getValue() == finalI)
                    System.out.printf("%s %d/%d-%d %02d:%02d:%02d - %02d:%02d:%02d - %s%n",
                    s.getDayOfWeek(),
                            s.getDayOfMonth(),
                            s.getMonthValue(),
                            s.getYear(), s.getHour(),
                            s.getMinute(),
                            s.getSecond(),
                            s2.getSubjectTimes().get(s).getHour(),
                            s2.getSubjectTimes().get(s).getMinute(),
                            s2.getSubjectTimes().get(s).getSecond(),
                            s2.getName());
            }));
        }
    }
}

