package GUI.MODEL;

import BE.*;
import BLL.StudentManager;

import java.util.ArrayList;
import java.util.List;

public class StudentModel {

    private List<Subject> subjects;
    private static StudentModel instance;
    private List<User> teachers;
    private List<Student> students;
    private List<Lecture> allLectures;

    private static StudentManager studentManager;

    /**
     * Get the singleton instance of StudentModel.
     */
    public static StudentModel getInstance() {
        if (instance == null) {
            instance = new StudentModel();
        }
        return instance;
    }

    private StudentModel() {
        studentManager = new StudentManager();
        subjects = new ArrayList<>();
        teachers = new ArrayList<>();
        students = new ArrayList<>();
        allLectures = new ArrayList<>();

        addUsers();
        addLectures();
        addSubjects();
        addAttendances();
    }


    private void addAttendances() {

        int[][] attendances = studentManager.getAttendances();
        System.out.println("attendances from db: " + attendances.length);

        for (int i = 0; i < attendances.length; i++) {
            //System.out.println("attendance " + i);
            for (Student s : students) {

                //System.out.println(s.getFirstName());
                if (s.getId() == attendances[i][0]) {
                    //System.out.println("id match");
                    for (Attendance a : s.getAttendances()) {
                        if (a.getLecture().getLectureId() == attendances[i][1]) {
                            //System.out.println("lecture match");
                            a.setAttended(attendances[i][2] == 1);
                        }
                    }
                }
            }
        }
    }

    private void addSubjects() {
        var allSubjects = studentManager.getSubjects();
        if (!allSubjects.isEmpty()) {
            for (Subject subject : allSubjects)
                subjects.add(subject);
        }
    }

    private void addLectures() {
        List<Lecture> allLectures = studentManager.getLectures();
        setAllLectures(allLectures);

        if (!students.isEmpty()) {

            // Add all the lectures to all the students.
            for (Student student : students) {
                student.setLectures(allLectures);
                for (Lecture l : allLectures) {
                    student.addAttendance(l);
                }
            }
        } else System.out.println("No students! Can't add lectures.");
    }

    private void addUsers() {
        List<User> allUsers = studentManager.getUsers();

        for (User u : allUsers) {
            if (u.getRole() == UserRole.Student) {
                students.add(new Student(u));
            } else {
                teachers.add(u);
            }
        }
    }

    public void setAllLectures(List<Lecture> allLectures) {
        this.allLectures = allLectures;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public List<User> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<User> teachers) {
        this.teachers = teachers;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Lecture> getAllLectures() {
        return allLectures;
    }

    /**
     * Get the students in a given subject.
     *
     * @param subject The subject to get students of.
     * @return Returns a list of students attending the subject.
     */
    public List<Student> getStudentsBySubject(Subject subject) {
        var foundStudents = new ArrayList<Student>();

        if (subject != null && !students.isEmpty()) {
            for (Student student : students) {
                var lectures = student.getLectures();
                for (Lecture lecture : lectures) {
                    var assignedSubject = lecture.getSubject();

                    if (assignedSubject != null && assignedSubject.getId() == subject.getId()) {
                        foundStudents.add(student);
                        //System.out.println("Filtered student: " + student.getFirstName());
                        break;
                    }
                    // else System.out.println("No student with subject found: " + assignedSubject.getName());
                }
            }
        }
        return foundStudents;
    }
}
