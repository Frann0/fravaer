package BE;

import Mock.Absence;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class User {
    private int id;
    private int role;
    private int totalAbsence;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private ArrayList<Subject> subjects;
    private List<Absence> attendance;
    private String mostAbsentDay;
    private List<LocalDate> absentDays;

    public User(int role, String username, String password, String firstName, String lastName) {
        setRole(role);
        setUsername(username);
        setPassword(password);
        setFirstName(firstName);
        setLastName(lastName);
        this.subjects = new ArrayList<>();
        this.attendance = new ArrayList<>();
        this.absentDays = new ArrayList<>();
        totalAbsence = setTotalAbsence();
    }

    public User(int id, int role, String username, String password, String firstName, String lastName) {
        setId(id);
        setRole(role);
        setUsername(username);
        setPassword(password);
        setFirstName(firstName);
        setLastName(lastName);
        this.subjects = new ArrayList<>();
        this.attendance = new ArrayList<>();
        this.absentDays = new ArrayList<>();
        totalAbsence = setTotalAbsence();
    }

    public User(int id, int role, String username, String password, String firstName, String lastName, String mostAbsentDay) {
        setId(id);
        setRole(role);
        setUsername(username);
        setPassword(password);
        setFirstName(firstName);
        setLastName(lastName);
        setMostAbsentDay(mostAbsentDay);
        this.subjects = new ArrayList<>();
        this.attendance = new ArrayList<>();
        this.absentDays = new ArrayList<>();
        totalAbsence = setTotalAbsence();
    }

    public User(int id, int role, String username, String password, String firstName, String lastName, List<Absence> attendance) {
        setId(id);
        setRole(role);
        setUsername(username);
        setPassword(password);
        setFirstName(firstName);
        setLastName(lastName);
        this.subjects = new ArrayList<>();
        this.attendance = attendance;
        totalAbsence = setTotalAbsence();
    }

    public void setAbsentDays(List<LocalDate> absentDays) {
        this.absentDays = absentDays;
    }

    private int setTotalAbsence(){
        Random rand = new Random();
        return rand.nextInt(20) + 75;
    }

    public int getTotalAbsence() {
        return totalAbsence;
    }

    public void setMostAbsentDay(String mostAbsentDay) {
        this.mostAbsentDay = mostAbsentDay;
    }

    public List<Absence> getAttendance() {
        return attendance;
    }

    public void addAttendance(Absence lectureAbsence){
        this.attendance.add(lectureAbsence);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public ArrayList<Subject> getSubjects() {
        return subjects;
    }

    public void addSubject(Subject c) {
        subjects.add(c);
    }

    public void addSubjects(ArrayList<Subject> c) {
        subjects.addAll(c);
    }

    public void removeSubject(Subject c) {
        subjects.remove(c);
    }

    public void removeSubjects(ArrayList<Subject> c) {
        subjects.removeAll(c);
    }

    public float getAbsenceBySubject(String subjectName){
        float lectureCount = 0;
        float absentLectures = 0;

        for(Absence abs : attendance){
            if(subjectName.equals(abs.getSubjectName())){
                lectureCount++;
                if(abs.getAbsent()){
                    absentLectures++;
                }
            }
        }
        return (float) (absentLectures / lectureCount) * 100;
    }

}
