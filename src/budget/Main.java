package budget;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Entry point for the Budget Manager application.
 */
public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setTitle("Budget Manager");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
