package ba.unsa.etf.rpr;

import java.sql.*;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO{
    private static CustomerDAOImpl instance = null;
 public static CustomerDAOImpl getInstance()throws SQLException{
     if(instance == null) instance = new CustomerDAOImpl();
     return instance;
 }

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
    public int insert(Customer customer) throws SQLException {
        /*Connection connection;
        String url = "jdbc:mysql://sql.freedb.tech:3306/freedb_rpr baza";
        String username="freedb_abuturovic1";
        String pass = System.getenv("DB_PASSWORD");
        connection = DriverManager.getConnection(url,username,pass);
        String sql = "INSERT INTO Customer (customer_id, username, password, first_name, last_name, email, phone_number) VALUES (?,?,?,?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1,customer.getCustomerID());
        ps.setString(2, customer.getUsername());
        ps.setString(3, customer.getPassword());
        ps.setString(4, customer.getFirstName());
        ps.setString(5,customer.getLastName());
        ps.setString(6, customer.getEmail());
        ps.setString(7, customer.getPhoneNumber());

        int res = ps.executeUpdate();

        return res;

*/
        return 0;
    }

    @Override
    public int update(Customer customer) throws SQLException {
        Connection connection;
        String url = "jdbc:mysql://sql.freedb.tech:3306/freedb_rpr baza";
        String username="freedb_abuturovic1";
        String pass = System.getenv("DB_PASSWORD");
        connection = DriverManager.getConnection(url,username,pass);
        String sql = "UPDATE Customer set customer_id=?, username=?, password=?, first_name=?, last_name=?, email=?, phone_number=? where id=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1,customer.getCustomerID());
        ps.setString(2, customer.getUsername());
        ps.setString(3, customer.getPassword());
        ps.setString(4,customer.getFirstName());
        ps.setString(5, customer.getLastName());
        ps.setString(6, customer.getEmail());
        ps.setString(7,customer.getPhoneNumber());
        int res = ps.executeUpdate();

        return res;
    }

    @Override
    public void delete(Customer customer) {

    }
    @Override
    public List<Customer> getbyUsername(String username) {

        return null;

    }
}
