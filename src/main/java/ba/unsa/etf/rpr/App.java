package ba.unsa.etf.rpr;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String url = "jdbc:mysql://sql.freedb.tech:3306/freedb_rpr baza";
        //String user = "freedb_abuturovic1";
        //  String password = "Qb%TgZbRVWft5bZ";
        // String user = System.getenv("DB_USERNAME");
        // String password = System.getenv("DB_PASSWORD");
        Properties properties = new Properties();
        try (InputStream input = App.class.getClassLoader().getResourceAsStream("config.properties")) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String user = properties.getProperty("db.username");
        String password = properties.getProperty("db.password");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url,user,password);
            System.out.println("Connection is successful to the database " +url);

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
