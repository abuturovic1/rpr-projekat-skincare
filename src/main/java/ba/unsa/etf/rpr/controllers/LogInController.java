package ba.unsa.etf.rpr.controllers;


import ba.unsa.etf.rpr.CustomerDAO;
import ba.unsa.etf.rpr.CustomerImpl;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

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
    switchToRegistrationButton.setOnAction(this::switchToSignup);
    }

    public void loginAccount() throws SQLException {
        /*String url = "jdbc:mysql://sql.freedb.tech:3306/freedb_rpr baza";
        String username="freedb_abuturovic1";
        String pass = System.getenv("DB_PASSWORD");
        connection = DriverManager.getConnection(url,username,pass);
        String sql = "SELECT username,password FROM Customer WHERE username = ? and password = ? ";*/
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
                if(customerDAO.authenticateUser(username,password)){
                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Succesfull LogIn!");
                    alert.showAndWait();
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
public void switchToSignup(ActionEvent event){
    Stage stage = (Stage)su_hyperlink.getScene().getWindow();
    stage.close();

}



}
