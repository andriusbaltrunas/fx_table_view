package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader load = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = load.load();
        primaryStage.setTitle("Hello World");

        // using on close event in controller
        Controller controller = load.getController();
        primaryStage.setOnHidden( event -> controller.onCloseEvent());

        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    //if needed close method in main class
    /*@Override
    public void stop() throws Exception {

    }*/

    public static void main(String[] args) {
        launch(args);
    }
}
