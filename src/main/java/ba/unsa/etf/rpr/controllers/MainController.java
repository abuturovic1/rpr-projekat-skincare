package ba.unsa.etf.rpr.controllers;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;
import java.io.IOException;
public class MainController {
    @FXML
    private TabPane tabPane;

    @FXML
    private Tab loginTab;

    @FXML
    private Tab registrationTab;

    @FXML
    public void initialize() {
        // Load Login FXML and set it as content for loginTab
        loadAndSetContent(loginTab, "login.fxml");

        // Load Registration FXML and set it as content for registrationTab
        loadAndSetContent(registrationTab, "registration.fxml");
    }

    private void loadAndSetContent(Tab tab, String fxmlFileName) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFileName));
            Parent root = loader.load();
            tab.setContent(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launchApp(args);
    }

    public static void launchApp(String[] args) {
        Application.launch(args);
    }
}
}
