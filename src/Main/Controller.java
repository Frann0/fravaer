package Main;

import BE.User;
import DAL.UserDAL;
import Dashboard.DashboardController;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.swing.border.Border;
import java.io.IOException;
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

    private UserDAL userDAL = new UserDAL();

    public void exit() {
        System.exit(0);
    }

    public void minimize(MouseEvent mouseEvent) {
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setIconified(true);
    }

    public void maximize(MouseEvent mouseEvent) {

    }

    public void login(MouseEvent mouseEvent) throws IOException {
        List<User> users = userDAL.loadUsers();
        User n = null;
        for (User u : users) {
            if (txtUsername.getText().contains(u.getUsername()) && txtPassword.getText().contains(u.getPassword())) {
                n = u;
                break;
            }
        }

        if (n != null) {
            Stage root1 = (Stage) root.getScene().getWindow();

            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/Dashboard/dashboard.fxml"));

            Scene scene = new Scene(fxmlLoader.load());

            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(scene);
            stage.show();

            DashboardController controller = fxmlLoader.getController();
            controller.setUser(n);
            controller.setName(n.getFirstName());
            if (n.getRole() == 2){
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
}
