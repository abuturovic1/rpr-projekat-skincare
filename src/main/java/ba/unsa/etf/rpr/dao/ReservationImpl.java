package ba.unsa.etf.rpr.dao;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import ba.unsa.etf.rpr.Reservation;
import ba.unsa.etf.rpr.exceptions.ReservationException;

/**
 * The ReservationImpl class implements the ReservationDAO interface and provides methods for accessing and managing reservations
 */
public class ReservationImpl implements ReservationDAO {

    private Connection connection;
    PreparedStatement pretraga_ps,dodaj_ps,izmijeni_ps,sveRezervacije_ps,brisanje_ps,pretragaK_ps,noviId,datum_ps;

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
        Properties properties = new Properties();

        try{
            properties.load(ClassLoader.getSystemResource("application.properties").openStream());
            String url = properties.getProperty("db.url");
            String username = properties.getProperty("db.username");
            String pass = properties.getProperty("db.password");
            connection = DriverManager.getConnection(url,username,pass);
        }catch(IOException e){
            e.printStackTrace();
        }
        pretraga_ps = connection.prepareStatement("SELECT * FROM Reservation WHERE reservation_id = ? ");
        sveRezervacije_ps = connection.prepareStatement("SELECT * FROM Reservation");
        izmijeni_ps = connection.prepareStatement("UPDATE Reservation SET customer_id=?, treatment_id = ?, reservation_date = ? , reservation_time = ? , status = ? WHERE reservation_id = ? ");
        brisanje_ps = connection.prepareStatement("DELETE FROM Reservation WHERE reservation_id = ?");
        //retrieve reservations for a specific customer using their ID
        //search for customer reservation informations by entering customer id..
        pretragaK_ps=connection.prepareStatement("SELECT * FROM Reservation WHERE customer_id = ?");
        noviId = connection.prepareStatement("SELECT MAX(reservation_id)+1 FROM Reservation");
        dodaj_ps = connection.prepareStatement("INSERT INTO Reservation VALUES (?,?,?,?,?,?)");
        datum_ps = connection.prepareStatement("SELECT COUNT(*) FROM Reservation WHERE reservation_date = ?");
    }
/*    @Override
    public ArrayList<Reservation> get(int id) {

        return null;
    }*/
    @Override
    public ArrayList<Reservation> get(int customerID) throws ReservationException{
        ArrayList<Reservation> reservations = new ArrayList<>();
        try{
           pretragaK_ps.setInt(1,customerID);
            ResultSet rs = pretragaK_ps.executeQuery();
            while (rs.next()) {
                Reservation reservation = new Reservation();
                reservation.setReservationID(rs.getInt("reservation_id"));
                reservation.setCustomerID(rs.getInt("customer_id"));
                reservation.setTreatmentID(rs.getInt("treatment_id"));
                reservation.setReservationDate(rs.getString("reservation_date"));
                reservation.setTime(rs.getString("reservation_time"));
                reservation.setStatus(rs.getString("status"));

                reservations.add(reservation);
                //reservations.add(new Reservation(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getDate(4),rs.getTime(5),rs.getString(6)));
            }

        }catch (SQLException e) {
            throw new ReservationException("Neuspjesno dobijanje informacija o rezervaciji unošenjem customerID",e);

        }

        return reservations;
    }
    @Override
    public List<Reservation> getAll() throws ReservationException{

        ArrayList<Reservation>reservations = new ArrayList<Reservation>();
        try{
            ResultSet rs = sveRezervacije_ps.executeQuery();
            while(rs.next()){
                reservations.add(new Reservation(rs.getInt(1),rs.getInt(2),rs.getInt(3),
                        rs.getString(4), rs.getString(5),
                        rs.getString(6)));

            }
        } catch (SQLException e) {
            throw new ReservationException("Neuspjesno dobijanje svih rezervacija",e);
        }
        return reservations;
    }

    @Override
    public void save(Reservation reservation) {
        try{
            ResultSet rs =  noviId.executeQuery();
            if(rs.next()) reservation.setReservationID(rs.getInt(1));
            else reservation.setReservationID(1);
            // dodavanje upit i setovanje
            dodaj_ps.setInt(1, reservation.getReservationID());
            dodaj_ps.setInt(2, reservation.getCustomerID());
            dodaj_ps.setInt(3, reservation.getTreatmentID());
            dodaj_ps.setString(4, reservation.getReservationDate());
            dodaj_ps.setString(5, String.valueOf(reservation.getTime()));
            dodaj_ps.setString(6, reservation.getStatus());

            dodaj_ps.execute();
        } catch(SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public void update(Reservation reservation) {
        try {
            izmijeni_ps.setInt(6,reservation.getReservationID());
            izmijeni_ps.setInt(1,reservation.getCustomerID());
            izmijeni_ps.setInt(2,reservation.getTreatmentID());
            izmijeni_ps.setString(3, String.valueOf(reservation.getReservationDate()));
            izmijeni_ps.setString(4, String.valueOf(reservation.getTime()));
            izmijeni_ps.setString(5,reservation.getStatus());

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Reservation reservation) {
        try {
            brisanje_ps.setInt(1, reservation.getReservationID());
            brisanje_ps.execute();
        } catch(SQLException e){
            e.printStackTrace();
        }

    }
    @Override
    public boolean isReservationDateTaken(String reservationDate) {
        try {

            datum_ps.setString(1, reservationDate);

            ResultSet resultSet = datum_ps.executeQuery();
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
