package GUI.MODEL;

import BE.*;
import BLL.StudentManager;

import java.util.ArrayList;
import java.util.List;

public class StudentModel {

    private List<String> subjects;
    private static StudentModel instance;
    private List<User> teachers;
    private List<Student> students;
    private List<Lecture> allLectures;

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


    private void addAttendances() {

        int[][] attendances = studentManager.getAttendances();
        System.out.println("attendances from db: " + attendances.length);

        for(int i = 0; i < attendances.length; i++){
            System.out.println("attendance " + i);
            for(Student s : students){
                for(Lecture l : allLectures){
                    s.addAttendance(l);
                }
                System.out.println(s.getFirstName());
                if(s.getId() == attendances[i][0]){
                    System.out.println("id match");
                    for(Attendance a : s.getAttendances()){
                        if(a.getLecture().getLectureId() == attendances[i][1]){
                            System.out.println("lecture match");
                            a.setAttended(attendances[i][2] == 1);
                        }
                    }
                }
            }
        }


    }

    private void setSubjects() {
        while(true){
            if(!allLectures.isEmpty()){
                for(Lecture l : allLectures){
                    if(!subjects.contains(l.getSubjectName())){
                        subjects.add(l.getSubjectName());
                    }
                }
                break;
            }
        }

    }

    private void addLectures() {
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

    private void addUsers() {
        List<User> allUsers = studentManager.getUsers();
        
        for(User u : allUsers){
            if(u.getRole() == UserRole.Student){
                students.add(new Student(u));
            } else{
                teachers.add(u);
            }
        }
    }

    public void setAllLectures(List<Lecture> allLectures) {
        this.allLectures = allLectures;
    }

    public List<String> getSubjects() {
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


}
