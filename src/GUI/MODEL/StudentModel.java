package GUI.MODEL;

import BE.*;
import BLL.StudentManager;

import java.util.ArrayList;
import java.util.List;

public class StudentModel {

    public static List<String> subjects;
    private static StudentModel instance;
    public static List<User> teachers;
    public static List<Student> students;
    public static List<Lecture> allLectures;

    private static StudentManager studentManager;

    /**
     * Get the singleton instance of StudentModel.
     */
    public static StudentModel getInstance() {
        if (instance == null){
            instance = new StudentModel();
        }
        return instance;
    }

    private StudentModel(){
        studentManager = new StudentManager();
        subjects = new ArrayList<>();
        teachers = new ArrayList<>();
        students = new ArrayList<>();
        allLectures = new ArrayList<>();

        addUsers();
        addLectures();
        setSubjects();
        addAttendances();
    }


    private static void addAttendances() {

        int[][] attendances = studentManager.getAttendances();

        for(int i = 0; i < attendances.length; i++){
            for(Student s : students){
                if(s.getId() == attendances[i][0]){
                    for(Attendance a : s.getAttendances()){
                        if(a.getLecture().getLectureId() == attendances[i][1]){
                            a.setAttended(attendances[i][2] == 1);
                        }
                    }
                }
            }
        }


    }

    private static void setSubjects() {
        while(true){
            if(!allLectures.isEmpty()){
                for(Lecture l : allLectures){
                    if(subjects.contains(l.getSubjectName())){
                        subjects.add(l.getSubjectName());
                    }
                }
                break;
            }
        }

    }

    private static void addLectures() {
        List<Lecture> allLectures = studentManager.getLectures();
        setAllLectures(allLectures);

        while(true){
            if(!students.isEmpty()){
                for(Student s : students){
                    s.setLectures(allLectures);
                }
                break;
            }
        }
    }

    private static void addUsers() {
        List<User> allUsers = studentManager.getUsers();
        
        for(User u : allUsers){
            if(u.getRole() == UserRole.Student){
                students.add(new Student(u));
            } else{
                teachers.add(u);
            }
        }
    }

    public static void setAllLectures(List<Lecture> allLectures) {
        StudentModel.allLectures = allLectures;
    }

    public static List<String> getSubjects() {
        return subjects;
    }

    public static void setSubjects(List<String> subjects) {
        StudentModel.subjects = subjects;
    }

    public static List<User> getTeachers() {
        return teachers;
    }

    public static void setTeachers(List<User> teachers) {
        StudentModel.teachers = teachers;
    }

    public static List<Student> getStudents() {
        return students;
    }

    public static void setStudents(List<Student> students) {
        StudentModel.students = students;
    }

    public static List<Lecture> getAllLectures() {
        return allLectures;
    }


}
