package ba.unsa.etf.rpr.controllers;
import ba.unsa.etf.rpr.Customer;
import ba.unsa.etf.rpr.CustomerImpl;
import ba.unsa.etf.rpr.Reservation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.event.ActionEvent;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class CrudController implements Initializable{
    @FXML
    private Button crud_addBtn;

    @FXML
    private TableColumn<?, ?> crud_col_email;

    @FXML
    private TableColumn<?, ?> crud_col_firstname;

    @FXML
    private TableColumn<?, ?> crud_col_id;

    @FXML
    private TableColumn<?, ?> crud_col_lastname;

    @FXML
    private TableColumn<?, ?> crud_col_phone;

    @FXML
    private TableColumn<?, ?> crud_col_username;

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
    private CustomerImpl customerdao;
    Connection connection;
    private ObservableList<Customer> customersList = FXCollections.observableArrayList();

    public void loadCustomers() throws SQLException {
        CustomerImpl customerImpl = new CustomerImpl();
        List<Customer> customers = customerImpl.getAll();

        customersList.setAll(customers);
    }




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
