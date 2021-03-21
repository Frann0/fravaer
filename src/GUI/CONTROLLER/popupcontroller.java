package GUI.CONTROLLER;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class popupcontroller {
    @FXML
    private AnchorPane root;


    public void handleYes(){
        System.out.println("Registreret fravær");
        Stage root1 = (Stage) root.getScene().getWindow();

        root1.close();
    }

    public void handleNo(){
        System.out.println("Ikke registreret fravær");
        Stage root1 = (Stage) root.getScene().getWindow();

        root1.close();
    }
}
