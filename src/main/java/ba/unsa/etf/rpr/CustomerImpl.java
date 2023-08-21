package ba.unsa.etf.rpr;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerImpl implements CustomerDAO{
    private Connection connection;
    private PreparedStatement ps_pretraziSve,ps_dodaj;
    private static CustomerImpl instance = null;

    private CustomerImpl() throws SQLException{
        String url = "jdbc:mysql://sql.freedb.tech:3306/freedb_rpr baza";
        String username="freedb_abuturovic1";
        String pass = System.getenv("DB_PASSWORD");
        connection = DriverManager.getConnection(url,username,pass);
        ps_pretraziSve = connection.prepareStatement("SELECT * FROM Customer");


    }



 public static CustomerImpl getInstance()throws SQLException{
     if(instance == null) instance = new CustomerImpl();
     return instance;
 }
 public static void removeInstance () throws SQLException{
     if(instance == null) return;
     instance.connection.close();
     instance=null;
 }

    @Override
    public ArrayList<Customer> get(int id) {

        //ArrayList<Customer> customers = new ArrayList<Customer>();
        return null;
    }

     /*
    Customer customer = null;

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
        return customer;*/
    @Override
    public List<Customer> getAll() {
        ArrayList<Customer>customers = new ArrayList<Customer>();
        try{
            ResultSet rs = ps_pretraziSve.executeQuery();
            while(rs.next()){
                customers.add(new Customer(rs.getInt(1),rs.getString(2),rs.getString(3),
                        rs.getString(4),rs.getString(5),
                        rs.getString(6),rs.getString(7)));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customers;
    }

    @Override
    public void save(Customer customer) {

    }


    @Override
    public void update(Customer customer){

    }

    @Override
    public void delete(Customer customer) {

    }
    @Override
    public List<Customer> getbyUsername(String username) {
        return null;

    }




}
