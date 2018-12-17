import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

import javafx.scene.layout.*;

public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    // Attribute 

    public void start(Stage stage) {
        Controller controller = new Controller();
        View root = controller.getView();
        Scene scene = new Scene(root);         
        stage.setTitle("App");
        stage.setScene(scene);
        stage.show();
    }

}