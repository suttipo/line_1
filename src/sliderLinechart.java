import javafx.geometry.Insets;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class sliderLinechart {

    public BorderPane getSliderLineChart(){
        BorderPane main = new BorderPane();
        VBox topMenu = new VBox();
        NumberAxis xAxis = new NumberAxis(0, 30, 1);
        NumberAxis yAxis = new NumberAxis();
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        
        BorderPane monthSaving = new BorderPane();
        monthSaving.setPadding(new Insets(30));
        Label labelMonthSaving = new Label("Monthly savings");
        
        //Create the Slider1 (min, max, initial value)
        Slider slider1 = new Slider(0, 250, 25);
        //Create a Label to display the current value
        Label month = new Label(String.valueOf(slider1.getValue()));
        //set property of slider1
        slider1.setShowTickMarks(true);//set show tick marks ขีด
        slider1.setShowTickLabels(true);
        slider1.setMajorTickUnit(25);
        slider1.setMinorTickCount(4);
        slider1.setSnapToTicks(true);
        //add label slider1 on monthSaving
        monthSaving.setLeft(labelMonthSaving);
        monthSaving.setCenter(slider1);
        monthSaving.setRight(month);

        BorderPane yearInterestRate = new BorderPane();
        yearInterestRate.setPadding(new Insets(10));
        Label labelYearInterestRate = new Label( "Yearly interest rate");
        
        // Create the Slider2 (min, max, initial value)
        Slider slider2 = new Slider(0, 10, 1);
        //Create a Label to display the current value
        Label rate = new Label(String.valueOf(slider2.getValue()));
        //set property of 2
        slider2.setShowTickMarks(true);//set show tick marks ขีด
        slider2.setShowTickLabels(true);
        slider2.setMajorTickUnit(1);
        slider2.setMinorTickCount(10);
        slider2.setSnapToTicks(true);
        //add label slider2 on yearInterestRate borderpane
        yearInterestRate.setLeft(labelYearInterestRate);
        yearInterestRate.setCenter(slider2);
        yearInterestRate.setRight(rate);

        //add monthSaving , yearInterestRate borderpane in to topmenu VBox
        topMenu.getChildren().addAll(monthSaving, yearInterestRate);

        //add topmenu VBox to top of main borderpane
        main.setTop(topMenu);
        main.setCenter(lineChart);
        

        return main;
    }
}
