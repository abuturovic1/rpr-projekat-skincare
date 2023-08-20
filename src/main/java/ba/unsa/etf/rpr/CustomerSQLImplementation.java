package ba.unsa.etf.rpr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
public class CustomerSQLImplementation implements CustomerDAO{
    private Connection connection;
    Properties properties = new Properties();
    private CustomerSQLImplementation() throws SQLException{
        String url = "jdbc:mysql://sql.freedb.tech:3306/freedb_rpr baza";
        String username="freedb_abuturovic1";
        String pass = properties.getProperty("db.password");
        connection = DriverManager.getConnection(url,username,pass);
    }
    @Override
    public List<Customer> getbyUsername(String username) {
        List<Customer> customers = new ArrayList<>();
        String sql = "SELECT * FROM customers WHERE username = ? ";

        return null;

    }

    @Override
    public ArrayList<Customer> get(int id) {
        return null;
    }

    @Override
    public List<Customer> getAll() {
        return null;
    }

    @Override
    public void save(Customer customer) {

    }

    @Override
    public void update(Customer customer) {

    }

    @Override
    public void delete(Customer customer) {

    }
}
