import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.*;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.*;
import javafx.stage.Screen;

/**
 * Manages control flow for logins
 */
public class LoginManager {
    private Scene scene;

    //Login constructor
    public LoginManager(Scene scene) {

        this.scene = scene;
    }

    //If user types "admin" it launches admin window if not launches the customer window.
    public void authenticated(String user) {

        if(user.equals("admin") || user.equals("Admin")){

            showAdminWindow();

        }else

            showMainView(user);

    }

    //Sets up Admin scene.
    private void showAdminWindow() {

        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("AdminWindow.fxml")
            );

            Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();

            scene.setRoot((Parent) loader.load());
            scene.getWindow().setHeight(400.0);
            scene.getWindow().setWidth(500.0);
            scene.getWindow().setX((primaryScreenBounds.getWidth()/2)-200);
            scene.getWindow().setY((primaryScreenBounds.getHeight()/2)-200);
        } catch (IOException ex) {
            Logger.getLogger(LoginManager.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //Sets up login scene
    public void showLoginScreen() {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("login.fxml")
            );
            scene.setRoot(loader.load());
            LoginController controller =
                    loader.getController();
            controller.initManager(this);
        } catch (IOException ex) {
            Logger.getLogger(LoginManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Sets up customer window.
    private void showMainView(String user) {
        try {

            File users = new File("Users.txt");

            FileWriter fw = new FileWriter(users.getAbsoluteFile(), true);

            fw.write((user + "\n"));

            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("mainview.fxml")
            );

            fw.close();

            Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();

            scene.setRoot(loader.load());
            scene.getWindow().setHeight(320.0);
            scene.getWindow().setWidth(580.0);
            scene.getWindow().setX((primaryScreenBounds.getWidth()/2)-200);
            scene.getWindow().setY((primaryScreenBounds.getHeight()/2)-200);

        } catch (IOException ex) {

        }
    }
}
