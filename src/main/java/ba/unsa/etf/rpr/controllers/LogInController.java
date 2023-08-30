package ba.unsa.etf.rpr.controllers;


import ba.unsa.etf.rpr.dao.CustomerDAO;
import ba.unsa.etf.rpr.dao.CustomerImpl;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.event.ActionEvent;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

/**
 * The LogInController class manages the functionality of the login form within the application's UI
 */
public class LogInController implements Initializable {
    @FXML
    private AnchorPane loginform;

    @FXML
    private Button si_logInBtn;
    @FXML
    private Button switchToRegistrationButton;
    @FXML
    private PasswordField si_password;

    @FXML
    private Button si_register;

    @FXML
    private TextField si_username;
    @FXML
    private Hyperlink su_hyperlink;


    private Connection connection;
    private PreparedStatement ps;
    private ResultSet rs;
    private CustomerImpl customerDAO;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        si_username.requestFocus();
        si_logInBtn.setOnAction(event -> {
            try{
                loginAccount();
            }catch(SQLException e){
                e.printStackTrace();
            }
        });
    }


    public void loginAccount() throws SQLException {
        String username = si_username.getText();
        String password = si_password.getText();
        CustomerDAO customerDAO = CustomerImpl.getInstance();
        try{
            Alert alert;
            if(si_username.getText().isEmpty() || si_password.getText().isEmpty()){
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all the blank fields");
                alert.showAndWait();
            } else{
                if(customerDAO.authenticateUser(username,password) ){
                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Succesfull LogIn!");
                    alert.showAndWait();
                    Stage stage = new Stage();
                    FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/reservation.fxml"));
                    stage.setScene(new Scene(loader.load(), USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
                    stage.show();
                }

            else{
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Incorrect username/password");
                alert.showAndWait();
            }



    }} catch(Exception e){
            e.printStackTrace();
        }
    }


    public void switchToSignup(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/reg.fxml"));
        stage.setScene(new Scene(loader.load(), USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        stage.show();
    }
}
