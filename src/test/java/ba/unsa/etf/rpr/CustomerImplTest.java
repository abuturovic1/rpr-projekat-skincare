package ba.unsa.etf.rpr;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class CustomerImplTest {
    private CustomerImpl customerDAO;

    @BeforeEach
    public void setUp() {
        // Initialize your CustomerDAO implementation before each test
        try {
            customerDAO = CustomerImpl.getInstance();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetCustomerById() {
        int customerIdToFind = 1; // Change this to a valid customer ID in your database
        List<Customer> customers = customerDAO.get(customerIdToFind);
        assertNotNull(customers);
        assertFalse(customers.isEmpty());
        assertEquals(1, customers.size());

        Customer foundCustomer = customers.get(0);
        assertEquals(customerIdToFind, foundCustomer.getCustomerID());

    }
    @Test
    public void testGetAllCustomers() {
        List<Customer> customers = customerDAO.getAll();
        assertNotNull(customers);
        assertFalse(customers.isEmpty());

    }
    @Test
    public void testUpdateCustomer() {
        int customerIdToUpdate = 1;
        Customer updatedCustomer = new Customer();
        updatedCustomer.setUsername("new_username");
        updatedCustomer.setPassword("new_password");
        updatedCustomer.setFirstName("FirstName");
        updatedCustomer.setLastName("LastName");
        updatedCustomer.setEmail("new_email");
        updatedCustomer.setPhoneNumber("new_phone_number");
        updatedCustomer.setCustomerID(customerIdToUpdate);
        customerDAO.update(updatedCustomer);
    }
}
