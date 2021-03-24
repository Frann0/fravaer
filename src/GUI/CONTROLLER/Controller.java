package GUI.CONTROLLER;

import BE.User;
import BE.UserRole;
import GUI.MODEL.LoginModel;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    @FXML
    private AnchorPane root;
    @FXML
    private JFXTextField txtUsername;
    @FXML
    private JFXPasswordField txtPassword;
    @FXML
    private Label lblError;

    //private UserDAL userDAL = new UserDAL();
    private double xOffset = 0;
    private double yOffset = 0;


    public void exit() {
        System.exit(0);
    }

    public void minimize(MouseEvent mouseEvent) {
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setIconified(true);
    }

    public void maximize(MouseEvent mouseEvent) {

    }

    public void login() throws IOException {
        LoginModel loginModel = new LoginModel();
        User user = loginModel.attemptLogin(txtUsername.getText(),txtPassword.getText());

        if (user != null) {
            Stage root1 = (Stage) root.getScene().getWindow();

            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/GUI/VIEW/DashboardView.fxml"));
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/GUI/VIEW/TeacherDashboardView.fxml"));

            Scene scene = new Scene(fxmlLoader.load());

            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(scene);
            stage.show();

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

            DashboardController controller = fxmlLoader.getController();
            controller.setUser(user);
            controller.setName(user.getFirstName());
            if (user.getRole() == UserRole.Admin){
                controller.setIsTeacher();
            }
            root1.close();

        } else {
            lblError.setText("The username or password is incorrect");
            lblError.setTextFill(Color.RED);
            txtPassword.clear();
            txtUsername.clear();
        }
    }

    /**
     * Login with the enter key.
     * @param keyEvent the keycode we check if its the ENTER key.
     * @throws IOException 
     */
    public void LoginByEnter(KeyEvent keyEvent) throws IOException {
        if (keyEvent.getCode() == KeyCode.ENTER){
            login();
        }
    }
}
