import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
//import javafx.scene.control.Label;
//import javafx.scene.layout.BorderPane;
//import javafx.scene.text.Font;
import javafx.stage.Stage;

public class App extends Application {
    public void start(Stage window){
    
        //create X axis and Y charts
        NumberAxis xAxis = new NumberAxis(2006, 2018, 2);
        NumberAxis yAxis = new NumberAxis(0, 100, 10);

        //label for title
        xAxis.setLabel("Year");
        yAxis.setLabel("Ranking");

        //create line chart with xAxis and yAxis
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("University of Helsinki, Shanghai Ranking");
        lineChart.setLegendVisible(false);//disable label name of data 
        //create data for add to line chart
        XYChart.Series<Number,Number> rankData = new XYChart.Series<>();
        //rankData.setName("Hel");

        rankData.getData().add(new XYChart.Data<>(2007, 73));
        rankData.getData().add(new XYChart.Data<>(2008, 68));
        rankData.getData().add(new XYChart.Data<>(2009, 72));
        rankData.getData().add(new XYChart.Data<>(2010, 72));
        rankData.getData().add(new XYChart.Data<>(2011, 74));
        rankData.getData().add(new XYChart.Data<>(2012, 73));
        rankData.getData().add(new XYChart.Data<>(2013, 76));
        rankData.getData().add(new XYChart.Data<>(2014, 73));
        rankData.getData().add(new XYChart.Data<>(2015, 67));
        rankData.getData().add(new XYChart.Data<>(2016, 56));
        rankData.getData().add(new XYChart.Data<>(2017, 56));

        //add data to line chart
        lineChart.getData().add(rankData);

        Scene scene = new Scene(lineChart, 640, 480);
        //window.setTitle("Test JavFx");
        window.setScene(scene);
        window.show();
    }
    public static void main(String[] args) throws Exception {
        //System.out.println("Hello, World!");
        launch(args);
    }
}
