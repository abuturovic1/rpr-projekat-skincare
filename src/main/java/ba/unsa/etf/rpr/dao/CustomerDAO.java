package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.Customer;

import java.util.List;

/**
 * The CustomerDAO interface defines methods for accessing customer data
 */
public interface CustomerDAO extends Dao<Customer> {

List<Customer>getbyUsername(String username);

    /**
     * Retrieves a list of all customers
     * @return Returning a list containing all customers
     */
    List<Customer> getAll();


    int getCustomerIdByUsername(String username);

    /**
     * Authenticates a user based on the provided username and password
     * @param username the username of the user/customer
     * @param password the password of the user/customer
     * @return true if authentication is successful, otherwise false.
     */
    boolean authenticateUser(String username, String password);

    /**
     * Checks if a given username is already taken
     * @param username the username to check
     * @return true if username is already taken, otherwise false
     */
    boolean isUsernameTaken(String username);
}

