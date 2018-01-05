import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.File;

public class Main extends Application {

    //main method that calls launch method from javafx
    public static void main(String[] args) {
        launch(args);
    }

    //start method from java fx, sets up the login window.
    @Override
    public void start(Stage primaryStage) {

        Scene scene = new Scene(new StackPane());

        LoginManager loginManager = new LoginManager(scene);
        loginManager.showLoginScreen();

        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
