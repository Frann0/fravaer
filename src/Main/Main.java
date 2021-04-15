package Main;

import BLL.DataGenerator;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {
    private double xOffset = 0;
    private double yOffset = 0;


    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../GUI/VIEW/LoginView.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.initStyle(StageStyle.TRANSPARENT);

        /*
        List<Student> studentList = new ArrayList<Student>(Arrays.asList(
                new Student(3, UserRole.Student, "madsq", "test", "Mads", "Qvistgaard"),
                new Student(4, UserRole.Student, "svendh", "test", "Svend", "Halding"),
                new Student(5, UserRole.Student, "jonasb", "test", "Jonas", "Buus"),
                new Student(6, UserRole.Student, "mikeh", "test", "Mike", "Hovedskov"),
                new Student(0, UserRole.Student, "Dennis", "test", "D", "P"),
                new Student(1, UserRole.Student, "Carlo", "test", "C", "De Leon")
        ));
        List<Subject> userSubjects = new ArrayList<>(Arrays.asList(
                new Subject("ITO"),
                new Subject("SCO"),
                new Subject("DBOS"),
                new Subject("SDE")
        ));

        userSubjects.get(3).getLectures().put(LocalDateTime.of(2021, 3, 22, 8, 45), LocalDateTime.of(2021, 3, 23, 10, 15));

        userSubjects.get(3).getLectures().put(LocalDateTime.of(2021, 3, 23, 8, 45), LocalDateTime.of(2021, 3, 23, 11, 15));
        userSubjects.get(1).getLectures().put(LocalDateTime.of(2021, 3, 23, 11, 15), LocalDateTime.of(2021, 3, 23, 14, 0));

        userSubjects.get(2).getLectures().put(LocalDateTime.of(2021, 3, 24, 8, 45), LocalDateTime.of(2021, 3, 23, 12, 0));

        userSubjects.get(0).getLectures().put(LocalDateTime.of(2021, 3, 25, 8, 45), LocalDateTime.of(2021, 3, 24, 12, 0));
        userSubjects.get(1).getLectures().put(LocalDateTime.of(2021, 3, 25, 12, 30), LocalDateTime.of(2021, 3, 24, 15, 0));

        userSubjects.get(1).getLectures().put(LocalDateTime.of(2021, 3, 26, 8, 45), LocalDateTime.of(2021, 3, 25, 11, 15));


        //Teachers
        List<User> teachers = new ArrayList<>(
                Arrays.asList(
                        new User(UserRole.Admin, "peters", "test", "Peter", "Stegger"),
                        new User(UserRole.Admin, "jeppe", "test", "Jeppe", "Deromkring")
                )
        );

        Course course = new Course("CSE2020", studentList, userSubjects);

        studentList.forEach(u -> {
            if (u.getRole() != UserRole.Admin)
                u.getCourses().add(course);
        });

        for (int i = 0; i < 7; i++)
            studentList.get(studentList.size() - 3).getAttendance().attendDate(LocalDateTime.of(2021, 3, 23, 8, 50).minusDays(i * 7));
        studentList.get(studentList.size() - 4).getAttendance().attendDate(LocalDateTime.now().minusHours(1).plusDays(1));
        studentList.get(studentList.size() - 3).getAttendance().attendDate(LocalDateTime.now().minusHours(1).plusDays(3));
        studentList.get(studentList.size() - 4).getAttendance().attendDate(LocalDateTime.now().minusHours(1).plusDays(2));

        studentList.get(0).printSubjects();

         */

        DataGenerator.debugTest();


        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });

        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                primaryStage.setX(event.getScreenX() - xOffset);
                primaryStage.setY(event.getScreenY() - yOffset);
                primaryStage.setOpacity(0.8f);
            }
        });

        root.setOnMouseDragExited((event) -> {
            primaryStage.setOpacity(1.0f);
        });

        root.setOnMouseReleased((event) -> {
            primaryStage.setOpacity(1.0f);
        });
    }


    public static void main(String[] args) {
        launch(args);
    }
}
