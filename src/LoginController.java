
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;

/** Controls the login screen */
public class LoginController {

    @FXML
    private TextField user;

    @FXML
    private TextField password;

    @FXML
    private Button loginButton;

    //Listener for login button.
    public void initManager(final LoginManager loginManager) {

        loginButton.setOnAction(new EventHandler<ActionEvent>() {

            //Checks if username is not empty.
            @Override
            public void handle(ActionEvent event) {

                if (!user.getText().equals("")) {

                    loginManager.authenticated(user.getText());

                }
            }
        });
    }

}
