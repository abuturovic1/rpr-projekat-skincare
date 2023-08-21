package ba.unsa.etf.rpr;

import java.sql.*;
import java.util.List;
import java.util.Properties;
public class CustomerDAOImpl implements CustomerDAO{
    @Override
    public Customer get(int id) throws SQLException{
    Customer customer = null;
    Connection connection;
    String url = "jdbc:mysql://sql.freedb.tech:3306/freedb_rpr baza";
    String username="freedb_abuturovic1";
        String pass = System.getenv("DB_PASSWORD");
    connection = DriverManager.getConnection(url,username,pass);
    String sql = "SELECT customer_id, username, password, first_name, last_name, email, phone_number FROM Customer WHERE customer_id = ?";
    PreparedStatement ps = connection.prepareStatement(sql);
    ps.setInt(1,id);
    ResultSet rs = ps.executeQuery();
    if(rs.next()){
        int oid = rs.getInt("customer_id");
        String userName = rs.getString("username");
        String passWord = rs.getString("password");
        String firstName =  rs.getString("first_name");
        String lastName = rs.getString("last_name");
        String eMail = rs.getString("email");
        String PhoneNumber = rs.getString("phone_number");
        customer = new Customer(oid,userName,passWord,firstName,lastName,eMail,PhoneNumber);

    }
        return customer;
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
    @Override
    public List<Customer> getbyUsername(String username) {

        return null;

    }
}
