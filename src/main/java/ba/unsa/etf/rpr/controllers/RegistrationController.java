package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.Customer;
import ba.unsa.etf.rpr.dao.CustomerImpl;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

/**
 * The controller class for the registration form in the application's UI
 * This class manages the behavior of the registration form UI elements
 */
public class RegistrationController implements Initializable {

    private CustomerImpl dao;
    @FXML
    private Hyperlink hyperlinkID;
    @FXML
    private Button switchToLoginButton;
    @FXML
    private TextField reg_id;
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
    private AnchorPane registrationForm;

    @FXML
            private AnchorPane loginform;

    Connection connection;
    PreparedStatement ps;
    private Runnable switchToLoginAction;
    private CustomerImpl customerDAO;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void registerAccount() throws SQLException{
        try {
            Alert alert;
            customerDAO = CustomerImpl.getInstance();
            if(customerDAO.isUsernameTaken(reg_username.getText())){
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("The username you entered is already taken");
                alert.showAndWait();

            }
            else if (reg_username.getText().isEmpty() || reg_pass.getText().isEmpty() || reg_firstname.getText().isEmpty() || reg_lastname.getText().isEmpty() || reg_email.getText().isEmpty() || reg_phoneN.getText().isEmpty()) {
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

                    Customer customer = new Customer();
                    customer.setUsername(reg_username.getText());
                    customer.setPassword(reg_pass.getText());
                    customer.setFirstName(reg_firstname.getText());
                    customer.setLastName(reg_lastname.getText());
                    customer.setEmail(reg_email.getText());
                    customer.setPhoneNumber(reg_phoneN.getText());

                    CustomerImpl customerDAO = new CustomerImpl();
                    customerDAO.save(customer);
                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Succesfull Registration! Welcome " +reg_username.getText() + "!");
                    alert.showAndWait();
                    Stage stage = new Stage();
                    FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/logIn.fxml"));
                    stage.setScene(new Scene(loader.load(), USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
                    stage.show();


            }
        }
        }catch(Exception e){
            e.printStackTrace();
        }



    }

    public void switchToLogin(ActionEvent event) throws IOException{
        Stage stage = (Stage)hyperlinkID.getScene().getWindow();
        stage.close();

    }






   /* @FXML
    public void initialize() throws SQLException{
        dao = CustomerImpl.getInstance();

    }*/

}
