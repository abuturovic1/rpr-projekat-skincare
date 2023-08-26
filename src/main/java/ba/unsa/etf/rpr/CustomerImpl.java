package ba.unsa.etf.rpr;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerImpl implements CustomerDAO{
    private Connection connection;
    private PreparedStatement ps_pretraziSve,ps_dodaj,noviIdUpit,ps_pretraga,ps_izmjena,ps_brisanje,ps_dodaj_up;
    private static CustomerImpl instance = null;

    private CustomerImpl() throws SQLException{
        String url = "jdbc:mysql://sql.freedb.tech:3306/freedb_rpr baza";
        String username="freedb_abuturovic1";
        String pass = System.getenv("DB_PASSWORD");
        connection = DriverManager.getConnection(url,username,pass);
        ps_pretraziSve = connection.prepareStatement("SELECT * FROM Customer");
        ps_dodaj = connection.prepareStatement("INSERT INTO Customer VALUES (?,?,?,?,?,?,?)");
        noviIdUpit = connection.prepareStatement("SELECT MAX(customer_id)+1 FROM Customer");
        ps_pretraga = connection.prepareStatement("SELECT * FROM Customer WHERE customer_id = ? ");
        ps_izmjena = connection.prepareStatement("UPDATE Customer SET username = ?,password = ?,first_name = ?,last_name =?,email=?, phone_number = ? WHERE customer_id = ?");
        ps_brisanje = connection.prepareStatement("DELETE FROM Customer WHERE customer_id = ? ");
        //dodaj username i pass u Customer:
        ps_dodaj_up = connection.prepareStatement("INSERT INTO Customer (username,password) VALUES (?,?)");
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
        ArrayList<Customer> customers = new ArrayList<Customer>();
        try{
            ps_pretraga.setString(1,String.valueOf(id));
            ResultSet rs = ps_pretraga.executeQuery();
            while(rs.next()){
                customers.add(new Customer(rs.getInt(1),rs.getString(2),
                        rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)));
            }
            //System.out.println("Uspjesna konekcija");
        }catch(SQLException e){
            //System.out.println("Neuspjesna konekcija"+e.getMessage());
            throw new RuntimeException(e);

        }
        return customers;
    }

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
        try{
            ResultSet rs =  noviIdUpit.executeQuery();
            if(rs.next()) customer.setCustomerID(rs.getInt(1));
            else customer.setCustomerID(1);
        // dodavanje upit i setovanje
            ps_dodaj.setInt(1, customer.getCustomerID());
            ps_dodaj.setString(2, customer.getUsername());
            ps_dodaj.setString(3, customer.getPassword());
            ps_dodaj.setString(4, customer.getFirstName());
           ps_dodaj.setString(5, customer.getLastName());
            ps_dodaj.setString(6, customer.getEmail());
            ps_dodaj.setString(7, customer.getPhoneNumber());
            ps_dodaj.execute();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }


    @Override
    public void update(Customer customer){
        try {
            ps_izmjena.setInt(7,customer.getCustomerID());
            ps_izmjena.setString(1,customer.getUsername());
            ps_izmjena.setString(2,customer.getPassword());
            ps_izmjena.setString(3,customer.getFirstName());
            ps_izmjena.setString(4,customer.getLastName());
            ps_izmjena.setString(5,customer.getEmail());
            ps_izmjena.setString(6,customer.getPhoneNumber());
            ps_izmjena.execute();
        }catch(SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public void delete(Customer customer) {
        try {
            ps_brisanje.setInt(1, customer.getCustomerID());
            ps_brisanje.execute();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
    @Override
    public List<Customer> getbyUsername(String username) {
        return null;
    }





}
