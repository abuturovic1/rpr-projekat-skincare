package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.Customer;
import ba.unsa.etf.rpr.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
public interface CustomerDAO extends Dao<Customer> {

List<Customer>getbyUsername(String username);
    List<Customer> getAll();


    int getCustomerIdByUsername(String username);

    boolean authenticateUser(String username, String password);

    boolean isUsernameTaken(String username);
}

