package Main;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

public class FxmlLoader {

    private Pane view;


    public Pane getPage(String filename){

        try{
            URL fileURL = Main.class.getResource("/Dashboard/" + filename + ".fxml");
            if (fileURL == null){
                throw new java.io.FileNotFoundException("Couldn't find the fxml file");
            }

            view = new FXMLLoader().load(fileURL);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return view;
    }
}
