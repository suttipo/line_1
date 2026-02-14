import javafx.geometry.Insets;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class sliderLinechart {

    public BorderPane getSliderLineChart() {
        BorderPane main = new BorderPane();
        VBox topMenu = new VBox();
        NumberAxis xAxis = new NumberAxis(0, 30, 1);
        NumberAxis yAxis = new NumberAxis();
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        XYChart.Series<Number, Number> savingPerMonth = new XYChart.Series<>();
        XYChart.Series<Number, Number> ratePerYear = new XYChart.Series<>();

        BorderPane monthSaving = new BorderPane();
        monthSaving.setPadding(new Insets(30));
        Label labelMonthSaving = new Label("Monthly savings");

        // Create the Slider1 (min, max, initial value)
        Slider slider1 = new Slider(0, 250, 25);
        // Create a Label to display the current value
        Label month = new Label(String.valueOf(slider1.getValue()));
        // set property of slider1
        slider1.setShowTickMarks(true);// set show tick marks ขีด
        slider1.setShowTickLabels(true);
        slider1.setMajorTickUnit(25);
        slider1.setMinorTickCount(4);
        slider1.setSnapToTicks(true);
        slider1.setBlockIncrement(1);
        // add label slider1 on monthSaving
        monthSaving.setLeft(labelMonthSaving);
        monthSaving.setCenter(slider1);
        monthSaving.setRight(month);
        for (int i = 0; i <= 30; i++) {
            // System.out.println(newValue);

            savingPerMonth.getData().add(new XYChart.Data<>(i, (double) slider1.getValue() * 12 * i));

        }
        lineChart.getData().add(savingPerMonth);

        BorderPane yearInterestRate = new BorderPane();
        yearInterestRate.setPadding(new Insets(10));
        Label labelYearInterestRate = new Label("Yearly interest rate");

        // Create the Slider2 (min, max, initial value)
        Slider slider2 = new Slider(0, 10, 0);
        // Create a Label to display the current value
        Label rate = new Label(String.valueOf(slider2.getValue()));
        // set property of 2
        slider2.setShowTickMarks(true);// set show tick marks ขีด
        slider2.setShowTickLabels(true);
        slider2.setMajorTickUnit(1);
        slider2.setMinorTickCount(10);
        slider2.setSnapToTicks(true);
        //slider2.setBlockIncrement(.1);

        // slider1 Add a ChangeListener to react to value changes
        slider1.valueProperty().addListener((observable, oldValue, newValue) -> {
            month.setText(String.valueOf(newValue));
            // double temp = (double) newValue;
            // Disable animation to ensure immediate removal
            lineChart.setAnimated(false);
            savingPerMonth.getData().clear();
            // remove data in lineChart at index 0
            lineChart.getData().remove(savingPerMonth);
            for (int i = 0; i <= 30; i++) {
                // System.out.println(newValue);
                if (i == 0) {
                    savingPerMonth.getData().add(new XYChart.Data<>(i, 0));
                    //continue;
                }
                savingPerMonth.getData().add(new XYChart.Data<>(i, (double) newValue * 12 * i));
                System.out.println( newValue );
            }
            lineChart.getData().add(savingPerMonth);
            // set slider2
            ratePerYear.getData().clear();
            lineChart.getData().remove(ratePerYear);
            double rateYear = slider2.getValue() / 100.0;
            if (rateYear != 0) {
                System.out.println("rateYear " + rateYear);
                double value = slider1.getValue() * 12 * rateYear + slider1.getValue() * 12;

                for (int i = 0; i <= 30; i++) {
                    if (i == 0) {
                        ratePerYear.getData().add(new XYChart.Data<>(i, 0));
                    }
                    ratePerYear.getData().add(new XYChart.Data<>(i, value));
                    value = (value + slider1.getValue() * 12) * rateYear + (value + slider1.getValue() * 12);
                    // System.out.println("value " + value);
                }
                lineChart.getData().add(ratePerYear);
            }

            lineChart.setAnimated(true);

        });

        // add a ChangeListener to react to value change
        slider2.valueProperty().addListener((observable, oldValue, newValue) -> {
            // String.format("%.2f", doubleValue) .2 precision two place
            rate.setText(String.format("%.2f", newValue) + "%");
            lineChart.setAnimated(false);
            ratePerYear.getData().clear();
            lineChart.getData().remove(ratePerYear);
            double rateYear = (double) newValue / 100.0;
            double value = slider1.getValue() * 12 * rateYear + slider1.getValue() * 12;
            // System.out.println("out " + value);
            for (int i = 0; i <= 30; i++) {
                if (i == 0) {
                    ratePerYear.getData().add(new XYChart.Data<>(i, 0));
                }
                ratePerYear.getData().add(new XYChart.Data<>(i, value));
                value = (value + slider1.getValue() * 12) * rateYear + (value + slider1.getValue() * 12);
                // System.out.println("value " + value);
            }
            lineChart.getData().add(ratePerYear);
            lineChart.setAnimated(true);
        });
        // add label slider2 on yearInterestRate borderpane
        yearInterestRate.setLeft(labelYearInterestRate);
        yearInterestRate.setCenter(slider2);
        yearInterestRate.setRight(rate);

        // add monthSaving , yearInterestRate borderpane in to topmenu VBox
        topMenu.getChildren().addAll(monthSaving, yearInterestRate);

        // add topmenu VBox to top of main borderpane
        main.setTop(topMenu);
        main.setCenter(lineChart);
        return main;
    }
}
