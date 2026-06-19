package lk.ijse.lk.ijse.institute1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        //scene = new Scene(loadFXML("/lk/ijse/institute1/view/course"), 640, 480);
         scene = new Scene(loadFXML("/lk/ijse/institute1/view/classshedule"), 640, 480);
        //scene = new Scene(loadFXML("/lk/ijse/institute1/view/lecturer"), 640, 480);
        //scene = new Scene(loadFXML("/lk/ijse/institute1/view/student"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}