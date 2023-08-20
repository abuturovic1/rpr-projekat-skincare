package ba.unsa.etf.rpr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public interface CustomerDAO extends Dao<Customer> {
        //factory metoda - vraca instancu klase CustomerDAO
        //singleton patern
List<Customer>getbyUsername(String username);
    }

