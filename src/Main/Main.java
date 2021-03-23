package Main;

import BE.*;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.*;

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
        List<User> allUsers = new ArrayList<User>(Arrays.asList(
                new User(3, UserRole.Student, "madsq", "test", "Mads", "Qvistgaard"),
                new User(4, UserRole.Student, "svendh", "test", "Svend", "Halding"),
                new User(5, UserRole.Student, "jonasb", "test", "Jonas", "Buus"),
                new User(6, UserRole.Student, "mikeh", "test", "Mike", "Hovedskov"),
                new User(0, UserRole.Student, "Dennis", "test", "D", "P"),
                new User(1, UserRole.Student, "Carlo", "test", "C", "De Leon")
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
        User t1 = new User(UserRole.Admin, "peters", "test", "Peter", "Stegger");
        t1.setId(5);
        allUsers.add(t1);
        User t2 = new User(UserRole.Admin, "jeppe", "test", "Jeppe", "Deromkring");
        t2.setId(6);
        allUsers.add(t2);

        AClass aClass = new AClass("CSE2020", allUsers, userSubjects);

        allUsers.forEach(u -> {
            if (u.getRole() != UserRole.Admin)
                u.getaClasses().add(aClass);
        });

        for (int i = 0; i < 7; i++)
            allUsers.get(allUsers.size() - 3).getAttendance().attendDate(LocalDateTime.of(2021, 3, 23, 8, 50).minusDays(i * 7));
        allUsers.get(allUsers.size() - 4).getAttendance().attendDate(LocalDateTime.now().minusHours(1).plusDays(1));
        allUsers.get(allUsers.size() - 3).getAttendance().attendDate(LocalDateTime.now().minusHours(1).plusDays(3));
        allUsers.get(allUsers.size() - 4).getAttendance().attendDate(LocalDateTime.now().minusHours(1).plusDays(2));

        allUsers.get(0).printSubjects();
         */

        primaryStage.show();


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
