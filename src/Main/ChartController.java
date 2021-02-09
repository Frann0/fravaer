package Main;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.*;
import javafx.scene.layout.BorderPane;
import jdk.jfr.Category;

import java.net.URL;
import java.util.ResourceBundle;

public class ChartController implements Initializable {

    @FXML
    private BorderPane borderPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private void handleShowBarChart(ActionEvent actionEvent) {
        CategoryAxis xA = new CategoryAxis();
        xA.setLabel("Fag");

        NumberAxis yA = new NumberAxis();
        yA.setLabel("Procent fravær");

        BarChart barChart = new BarChart(xA,yA);

        XYChart.Series data = new XYChart.Series();
        data.setName("Fravær");

        //provided data
        data.getData().add(new XYChart.Data("SCO2",10));
        data.getData().add(new XYChart.Data("SDE2",15));
        data.getData().add(new XYChart.Data("DBO2",20));

        barChart.getData().add(data);

        // add barChar to borderPane
        borderPane.setCenter(barChart);


    }

    @FXML
    private void handleShowPieChart(ActionEvent actionEvent) {

        // create data
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("SCO2",10),
                new PieChart.Data("SDE2",15),
                new PieChart.Data("DBO2",20)
        );
        // create piechart objct
        PieChart pieChart = new PieChart(pieChartData);
        pieChart.setTitle("Fravær");
        pieChart.setClockwise(true);
        pieChart.setLabelLineLength(50);
        pieChart.setLabelsVisible(true);
        pieChart.setStartAngle(180);

        borderPane.setCenter(pieChart);
    }

    @FXML
    private void handleClose(ActionEvent actionEvent) {
        System.exit(0);
    }

    @FXML
    private void handleUpdateData(ActionEvent actionEvent) {
    }
}
