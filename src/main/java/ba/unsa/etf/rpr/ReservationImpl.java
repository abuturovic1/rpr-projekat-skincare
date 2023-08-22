package ba.unsa.etf.rpr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ReservationImpl implements ReservationDAO{
    private Connection connection;
    PreparedStatement pretraga_ps,dodaj_ps,izmijeni_ps,sveRezervacije_ps;

    private static ReservationImpl instance = null;
    public static ReservationImpl getInstance()throws SQLException{
        if(instance == null) instance = new ReservationImpl();
        return instance;
    }
    public static void removeInstance () throws SQLException{
        if(instance == null) return;
        instance.connection.close();
        instance=null;
    }
    private ReservationImpl() throws SQLException{

        String url = "jdbc:mysql://sql.freedb.tech:3306/freedb_rpr baza";
        String username="freedb_abuturovic1";
        String pass = System.getenv("DB_PASSWORD");
        connection = DriverManager.getConnection(url,username,pass);
        pretraga_ps = connection.prepareStatement("SELECT * FROM Reservation WHERE reservation_id = ? ");
        sveRezervacije_ps = connection.prepareStatement("SELECT * FROM Reservation");


    }
    @Override
    public ArrayList<Reservation> get(int id) {
        return null;
    }

    @Override
    public List<Reservation> getAll() {
        return null;
    }

    @Override
    public void save(Reservation reservation) {

    }

    @Override
    public void update(Reservation reservation) {
    }

    @Override
    public void delete(Reservation reservation) {

    }
}
