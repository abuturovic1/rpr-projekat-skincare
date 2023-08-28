package ba.unsa.etf.rpr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
//by extending our DAO in this manner, we actually provide for the ability to add additional methods in our
//CustomerDAO that are not present in our standard DAO.
public interface CustomerDAO extends Dao<Customer> {

List<Customer>getbyUsername(String username);
    List<Customer> getAll();


    }

