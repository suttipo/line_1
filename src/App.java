import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class App extends Application {
    public void start(Stage window){
        BorderPane main = new BorderPane();
        Label name = new Label("Hellow");
        //main.getChildren().add(name);
        name.setFont(Font.font("Arial",60));
        main.setCenter(name);
        Scene scene = new Scene(main, 700, 800);
        window.setTitle("Test JavFx");
        window.setScene(scene);
        window.show();
    }
    public static void main(String[] args) throws Exception {
        //System.out.println("Hello, World!");
        launch(args);
    }
}
