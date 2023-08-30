package ba.unsa.etf.rpr.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;
import java.io.IOException;
import javafx.scene.control.*;

/**
 * The controller class for the main page of the application
 * Manages the behavior of the main page UI elements
 */
public class MainpageController {
    @FXML
    private Button startID;
    public void startJourney() throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/logIn.fxml"));
        stage.setScene(new Scene(loader.load(), USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        stage.show();
    }

}
