package GUI.CONTROLLER;

import BE.Student;
import BE.User;
import BLL.DataGenerator;
import GUI.FxmlLoader;
import com.jfoenix.controls.JFXButton;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.rmi.registry.Registry;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {
    @FXML
    private AnchorPane dRoot;
    @FXML
    private Label lblName;
    @FXML
    private BorderPane borderPane;
    @FXML
    private JFXButton btnDashboard;
    @FXML
    private JFXButton btnRegistrer;
    @FXML
    private JFXButton btnRegistreringer;
    @FXML
    private TableView test;

    private final FxmlLoader loader = new FxmlLoader();
    private final FXMLLoader loader2 = new FXMLLoader();

    private User currentUser;
    private boolean isTeacher;

    private double xOffset = 0;
    private double yOffset = 0;

    public void setUser(User u){
        currentUser = u;
        
        FXMLLoader load = new FXMLLoader();
        load.setLocation(getClass().getResource("/GUI/VIEW/StudentDashboardView.fxml"));

        try {
            borderPane.setCenter(load.load());
            StudentDashboardController conn = load.getController();
            conn.setUser(currentUser);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void exit(){
        System.exit(0);
    }

    public void minimize(MouseEvent mouseEvent) {
        Stage stage = (Stage) dRoot.getScene().getWindow();
        stage.setIconified(true);
    }

    public void maximize(MouseEvent mouseEvent) {

    }

    public void logout() throws IOException {
        Stage root1 = (Stage) dRoot.getScene().getWindow();

        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/GUI/VIEW/LoginView.fxml"));

        Scene scene = new Scene(fxmlLoader.load());

        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.show();

        root1.close();
    }

    public void handleDashboard(){
        FXMLLoader load = new FXMLLoader();
        load.setLocation(getClass().getResource("/GUI/VIEW/StudentDashboardView.fxml"));

        try {
            borderPane.setCenter(load.load());
            StudentDashboardController conn = load.getController();
            conn.setUser(currentUser);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void handleRegistrer() throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/GUI/VIEW/PopUpView.fxml"));

        Parent root = (Parent) fxmlLoader.load();
        PopUpController popUpController = fxmlLoader.getController();

        Scene scene = new Scene(root);

        scene.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });

        scene.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage.setX(event.getScreenX() - xOffset);
                stage.setY(event.getScreenY() - yOffset);
                stage.setOpacity(0.8f);
            }
        });

        scene.setOnMouseDragExited((event) -> {
            stage.setOpacity(1.0f);
        });

        scene.setOnMouseReleased((event) -> {
            stage.setOpacity(1.0f);
        });



        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.show();
    }

    public void handleRegistreringer() throws IOException {
        Pane view = loader.getPage("RegistrationsView");

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/GUI/VIEW/RegistrationsView.fxml"));

        Parent root = (Parent) fxmlLoader.load();
        RegistrationsController registrationsController = fxmlLoader.getController();

        registrationsController.setUser(currentUser);

        borderPane.setCenter(view);
    }

    public void setIsTeacher(){
        btnDashboard.setVisible(false);
        btnDashboard.setDisable(true);

        btnRegistrer.setVisible(false);
        btnRegistrer.setDisable(true);

        btnRegistreringer.setVisible(false);
        btnRegistreringer.setDisable(true);

        /*
        FxmlLoader loader = new FxmlLoader();
        Pane view = loader.getPage("teacherdb");
         */
        FXMLLoader load = new FXMLLoader();
        load.setLocation(getClass().getResource("/GUI/VIEW/TeacherDashboardView.fxml"));

        try {
            borderPane.setCenter(load.load());
            TeacherDashboardController conn = load.getController();
            conn.setUser(currentUser);
        } catch(IOException e) {
            e.printStackTrace();
        }


        //borderPane.setCenter(view);
    }

    public void setName(String name){
        lblName.setText("Velkommen til, " + name);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Pane view = loader.getPage("StudentDashboardView");
        borderPane.setCenter(view);
    }
}
