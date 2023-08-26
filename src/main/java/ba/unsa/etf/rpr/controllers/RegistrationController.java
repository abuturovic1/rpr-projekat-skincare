package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.CustomerDAO;
import ba.unsa.etf.rpr.CustomerImpl;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class RegistrationController implements Initializable {

    //private CustomerImpl dao;


    @FXML
    private TextField reg_email;

    @FXML
    private TextField reg_firstname;

    @FXML
    private TextField reg_lastname;

    @FXML
    private PasswordField reg_pass;

    @FXML
    private TextField reg_phoneN;

    @FXML
    private TextField reg_username;

    @FXML
    private AnchorPane signupform;

    Connection connection;
    PreparedStatement ps;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void registerAccount() throws SQLException{
        String url = "jdbc:mysql://sql.freedb.tech:3306/freedb_rpr baza";
        String username="freedb_abuturovic1";
        String pass = System.getenv("DB_PASSWORD");
        connection = DriverManager.getConnection(url,username,pass);
        String sql = " INSERT INTO Customer (username, password, first_name,last_name,email,phone_number) VALUES (?,?,?,?,?,?)";
        try {
            Alert alert;
            if (reg_username.getText().isEmpty() || reg_pass.getText().isEmpty() || reg_firstname.getText().isEmpty() || reg_lastname.getText().isEmpty() || reg_email.getText().isEmpty() || reg_phoneN.getText().isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all the blank fields");
                alert.showAndWait();
            } else {
                if (reg_pass.getText().length() < 8) {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Invalid password, at least 8 characters needed");
                    alert.showAndWait();

                } else {

                    ps = connection.prepareStatement(sql);

                    ps.setString(1, reg_username.getText());
                    ps.setString(2, reg_pass.getText());
                    ps.setString(3, reg_firstname.getText());
                    ps.setString(4, reg_lastname.getText());
                    ps.setString(5, reg_email.getText());
                    ps.setString(6, reg_phoneN.getText());
                    // rs = ps.executeUpdate();
                    ps.executeUpdate();

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Succesfully created a new account!");
                    alert.showAndWait();
                }


            }
        }catch(Exception e){
            e.printStackTrace();
        }



    }
   /* @FXML
    public void initialize() throws SQLException{
        dao = CustomerImpl.getInstance();

    }*/

}