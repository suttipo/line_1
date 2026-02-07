import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;

import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class Multilinechart {

    /**
     * @return
     * @throws IOException
     */
    public LineChart<Number, Number> getLineChart() throws IOException {
        NumberAxis xAxis = new NumberAxis(1968, 2008, 4);
        NumberAxis yAxis = new NumberAxis(0, 30, 5);

        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);

        String fileInput = "D:\\java\\moocfi\\javaprogrammingii\\mooc-java-programming-ii\\part14-Part14_02.FinnishParties\\partiesdata.tsv";
        //FileReader fileToread = new FileReader(fileInput);
        try (BufferedReader reader = new BufferedReader(new FileReader(fileInput))) {
            String text;
            // Skip the header line if the file has one
            String header = reader.readLine(); 
            // System.out.println(text);
            // reader.readLine();
            while ((text = reader.readLine()) != null) {

                XYChart.Series<Number, Number> data = new XYChart.Series<>();
                //text = reader.readLine();
                String[] arrayText = text.split("\\t");

                for (int i = 0; i < arrayText.length; i++) {
                    
                    if (i == 0) {
                        data.setName(arrayText[i]);
                    } else {
                        int years = 1968 + ((i - 1) * 4);
                        if(arrayText[i].equals("-")){
                            continue;
                        }else{
                            data.getData().add(new XYChart.Data<>(years, Double.valueOf(arrayText[i])));
                        }
                    }
                }
            
                lineChart.getData().add(data);
            }
        } catch (IOException e) {
            // Todo
            e.printStackTrace();
        }
        return lineChart;
    }

}
