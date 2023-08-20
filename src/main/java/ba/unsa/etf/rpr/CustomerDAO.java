package ba.unsa.etf.rpr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface CustomerDAO extends Dao<Customer> {
        //factory metoda - vraca instancu klase CustomerDAO
        //singleton patern

    }

