package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.Reservation;
import ba.unsa.etf.rpr.dao.ReservationImpl;
import ba.unsa.etf.rpr.exceptions.ReservationException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Unit tests for the ReservationImpl class. Tests cover functionalities of the ReservationImpl class
 */
public class ReservationImplTest {

    private ReservationImpl reservationDAO;

    @Before
    public void setUp() throws SQLException {
        reservationDAO = ReservationImpl.getInstance();
    }

    /**
     * Closing the database connection and cleaning up the singleton instance of the ReservationImpl class
     * @throws SQLException
     */
    @After
    public void tearDown() throws SQLException {
        ReservationImpl.removeInstance();
    }

    @Test
    public void testGetAll() throws ReservationException {
        List<Reservation> reservations = reservationDAO.getAll();
        assertEquals(15, reservations.size());
    }

    @Test
    public void testGet() throws ReservationException {
        int customerId = 1;
        List<Reservation> reservations = reservationDAO.get(customerId);
        assertEquals(1, reservations.size());
    }

    @Test
    public void testSave() throws ReservationException {
        Reservation reservation = new Reservation();
        reservation.setReservationID(4);
        reservation.setCustomerID(123);
        reservation.setTreatmentID(456);
        reservation.setReservationDate("2023-09-03");
        reservation.setTime("15:00");
        reservation.setStatus("Pending");
        reservationDAO.save(reservation);

    }

    @Test
    public void testUpdate() {
        Reservation reservation = new Reservation();
        reservation.setReservationID(4);
        reservation.setCustomerID(123);
        reservation.setTreatmentID(456);
        reservation.setReservationDate("2023-09-03");
        reservation.setTime("15:00");
        reservation.setStatus("Confirmed");
        reservationDAO.update(reservation);

    }

    @Test
    public void testDelete() {
        Reservation reservation = new Reservation();
        reservation.setReservationID(4);
        reservation.setCustomerID(123);
        reservation.setTreatmentID(456);
        reservation.setReservationDate("2023-09-03");
        reservation.setTime("15:00");
        reservation.setStatus("Pending");
        reservationDAO.delete(reservation);

    }


}