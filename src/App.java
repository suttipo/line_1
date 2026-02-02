//import java.util.Scanner;

import javafx.application.Application;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
//import javafx.scene.Scene;
//import javafx.scene.chart.LineChart;
//import javafx.scene.chart.NumberAxis;
//import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
//import javafx.scene.layout.BorderPane;
//import javafx.scene.text.Font;
import javafx.stage.Stage;

public class App extends Application {
    public void start(Stage window){
        LineChart1 lineChart1 = new LineChart1();
        BorderPane main = new BorderPane();
        VBox menu = new VBox();
        Label one = new Label("1 Line Chart.");
        Label two = new Label("0 EXIT.");
        TextField select = new TextField();
        select.setOnAction(e -> {
            String n = select.getText();
            System.out.println(n);
            if(n.equals("1")){
                //System.out.println(num);
                main.setCenter(lineChart1.start());
                select.clear();
            }
        });
        menu.getChildren().addAll(one, two, select);
        main.setTop(menu);
        Scene scene = new Scene(main, 700, 800);
        window.setScene(scene);
        window.show();
        
        //window.show();
    }
    
    public static void main(String[] args) {
        //System.out.println("Hello, World!");
        launch(args);
    }
}
