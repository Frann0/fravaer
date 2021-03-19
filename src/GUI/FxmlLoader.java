package GUI;

import GUI.CONTROLLER.StudentdbController;
import Main.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;

public class FxmlLoader {

    private Pane view;
    private FXMLLoader fxmlLoader = new FXMLLoader();


    public Pane getPage(String filename){

        try{
            URL fileURL = Main.class.getResource("/GUI/FXML/" + filename + ".fxml");
            if (fileURL == null){
                throw new java.io.FileNotFoundException("Couldn't find the fxml file");
            }
            else
            view = new FXMLLoader().load(fileURL);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return view;
    }

    public StudentdbController getController(String filename) {

        try {
            URL fileURL = Main.class.getResource("/GUI/" + filename + ".fxml");
            if (fileURL == null){
                throw new java.io.FileNotFoundException("Couldn't find the fxml file");
            }
            fxmlLoader.setLocation(getClass().getResource("/GUI/" + filename + ".fxml"));

        }catch (IOException e){
            e.printStackTrace();
        }
        return fxmlLoader.getController();
    }
}
