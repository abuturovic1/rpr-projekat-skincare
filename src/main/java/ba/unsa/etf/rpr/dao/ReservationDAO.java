package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.Dao;
import ba.unsa.etf.rpr.Reservation;

import java.util.List;

/**
 * Defines methods for accessing and managing reservation data
 */
public interface ReservationDAO extends Dao<Reservation> {

    /**
     * Checks if a reservation date is already taken
     * @param reservationDate the reservation date to check for availability
     * @return it is true if the reservation date is already taken , otherwise false
     */
    boolean isReservationDateTaken(String reservationDate);
}
