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
}
