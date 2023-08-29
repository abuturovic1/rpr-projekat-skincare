package ba.unsa.etf.rpr.controllers;
import ba.unsa.etf.rpr.Customer;
import ba.unsa.etf.rpr.CustomerImpl;
import ba.unsa.etf.rpr.ReservationImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class CrudController implements Initializable{
    @FXML
    private TableColumn<Customer, String> crud_col_pass;
    @FXML
    private Button crud_addBtn;
    @FXML
    private TableView<Customer> crud_tableView;
    @FXML
    private TableColumn<Customer, String> crud_col_email;

    @FXML
    private TableColumn<Customer, String> crud_col_firstname;

    @FXML
    private TableColumn<Customer, String> crud_col_id;

    @FXML
    private TableColumn<Customer, String> crud_col_lastname;

    @FXML
    private TableColumn<Customer, String> crud_col_phone;

    @FXML
    private TableColumn<Customer, String> crud_col_username;

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
/*
    Connection connection;
    private ObservableList<Customer> customersList = FXCollections.observableArrayList();

    public ObservableList<Customer> loadCustomers() throws SQLException {
        String url = "jdbc:mysql://sql.freedb.tech:3306/freedb_rpr baza";
        String username="freedb_abuturovic1";
        String pass = System.getenv("DB_PASSWORD");
        connection = DriverManager.getConnection(url,username,pass);
        CustomerImpl customerImpl = new CustomerImpl();
        List<Customer> customers = customerImpl.getAll();

        customersList.setAll(customers);
        return customersList;
    }
    private ObservableList<Customer> customers;
    public void showCustomers() throws SQLException {
        customers = loadCustomers();
        crud_col_id.setCellValueFactory(new PropertyValueFactory<>("customer_id"));
        crud_col_username.setCellValueFactory(new PropertyValueFactory<>("username"));
        crud_col_pass.setCellValueFactory(new PropertyValueFactory<>("password"));
        crud_col_firstname.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        crud_col_lastname.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        crud_col_email.setCellValueFactory(new PropertyValueFactory<>("email"));
        crud_col_phone.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));

        crud_tableView.setItems(customers);


    }


*/
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        crud_col_id.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        crud_col_username.setCellValueFactory(new PropertyValueFactory<>("username"));
        crud_col_pass.setCellValueFactory(new PropertyValueFactory<>("password"));
        crud_col_firstname.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        crud_col_lastname.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        crud_col_email.setCellValueFactory(new PropertyValueFactory<>("email"));
        crud_col_phone.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        try {
            customerdao = CustomerImpl.getInstance();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }







    public void updateCustomer(javafx.event.ActionEvent actionEvent) {
        Customer selectedCustomer = crud_tableView.getSelectionModel().getSelectedItem();

        if (selectedCustomer != null) {
            // Update the selected customer's information
            selectedCustomer.setUsername(crud_username.getText());
            selectedCustomer.setFirstName(crud_firstname.getText());
            selectedCustomer.setLastName(crud_lastname.getText());
            selectedCustomer.setEmail(crud_email.getText());
            selectedCustomer.setPhoneNumber(crud_phone.getText());

            // Call the DAO method to update the customer
            customerdao.update(selectedCustomer);

        }

    }


    public void deleteCustomer(javafx.event.ActionEvent actionEvent) {
        Customer selectedCustomer = crud_tableView.getSelectionModel().getSelectedItem();
        if(selectedCustomer!=null) customerdao.delete(selectedCustomer);
    }
}
