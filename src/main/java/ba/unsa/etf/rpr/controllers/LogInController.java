package ba.unsa.etf.rpr.controllers;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.AnchorPane;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

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


    private Connection connection;
    private PreparedStatement ps;
    private ResultSet rs;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void loginAccount() throws SQLException {
        String url = "jdbc:mysql://sql.freedb.tech:3306/freedb_rpr baza";
        String username="freedb_abuturovic1";
        String pass = System.getenv("DB_PASSWORD");
        connection = DriverManager.getConnection(url,username,pass);
        String sql = "SELECT username,password FROM Customer WHERE username = ? and password = ? ";
        try{
            Alert alert;
            if(si_username.getText().isEmpty() || si_password.getText().isEmpty()){
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all the blank fields");
                alert.showAndWait();
            } else{
        ps = connection.prepareStatement(sql);
            ps.setString(1,si_username.getText());
            ps.setString(2,si_password.getText());
            rs = ps.executeQuery();

            if(rs.next()){
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



}
