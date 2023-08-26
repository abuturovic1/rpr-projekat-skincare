package ba.unsa.etf.rpr.controllers;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.AnchorPane;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
public class CrudController {
    @FXML
    private Button crud_addBtn;

    @FXML
    private TextField crud_customerID;

    @FXML
    private Button crud_deleteBtn;

    @FXML
    private TextField crud_email;

    @FXML
    private TextField crud_firstname;

    @FXML
    private TextField crud_lastname;

    @FXML
    private TextField crud_phone;

    @FXML
    private Button crud_updateBtn;

    @FXML
    private TextField crud_username;

}
