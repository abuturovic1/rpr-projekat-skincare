package ba.unsa.etf.rpr;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ReservationImpl implements ReservationDAO{
    private Connection connection;
    PreparedStatement pretraga_ps,dodaj_ps,izmijeni_ps,sveRezervacije_ps,brisanje_ps,pretragaK_ps;

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
        izmijeni_ps = connection.prepareStatement("UPDATE Reservation SET reservation_date = ? , reservation_time = ? , status = ? WHERE reservation_id = ? ");
        brisanje_ps = connection.prepareStatement("DELETE FROM Reservation WHERE reservation_id = ?");
        //retrieve reservations for a specific customer using their ID
        //search for customer reservation informations by entering customer id..
        pretragaK_ps=connection.prepareStatement("SELECT * FROM Reservation WHERE customer_id = ?");

    }
/*    @Override
    public ArrayList<Reservation> get(int id) {

        return null;
    }*/
    @Override
    public ArrayList<Reservation> get(int customerID) {
        ArrayList<Reservation> reservations = new ArrayList<>();
        try{
           pretragaK_ps.setInt(1,customerID);
            ResultSet rs = pretragaK_ps.executeQuery();
            while (rs.next()) {
                Reservation reservation = new Reservation();
                reservation.setReservationID(rs.getInt("reservation_id"));
                reservation.setCustomerID(rs.getInt("customer_id"));
                reservation.setTreatmentID(rs.getInt("treatment_id"));
                reservation.setReservationDate(rs.getDate("reservation_date"));
                reservation.setTime(rs.getTime("reservation_time"));
                reservation.setStatus(rs.getString("status"));

                reservations.add(reservation);
                //reservations.add(new Reservation(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getDate(4),rs.getTime(5),rs.getString(6)));
            }
            //System.out.println("Uspjesna konekcija");
        }catch (SQLException e) {
            throw new RuntimeException(e);
            //System.out.println("Neuspjesna konekcija"+e.getMessage());
        }

        return reservations;
    }
    @Override
    public List<Reservation> getAll() {

        ArrayList<Reservation>reservations = new ArrayList<Reservation>();
        try{
            ResultSet rs = sveRezervacije_ps.executeQuery();
            while(rs.next()){
                reservations.add(new Reservation(rs.getInt(1),rs.getInt(2),rs.getInt(3),
                        rs.getDate(4),rs.getTime(5),
                        rs.getString(6)));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return reservations;
    }

    @Override
    public void save(Reservation reservation) {

    }

    @Override
    public void update(Reservation reservation) {
        try {
            izmijeni_ps.setInt(6,reservation.getReservationID());
            izmijeni_ps.setInt(1,reservation.getCustomerID());
            izmijeni_ps.setInt(2,reservation.getTreatmentID());
            izmijeni_ps.setDate(3, (Date) reservation.getReservationDate());
            izmijeni_ps.setTime(4,reservation.getTime());
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
}
