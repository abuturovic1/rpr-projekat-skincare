package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.Dao;
import ba.unsa.etf.rpr.Reservation;

import java.util.List;

public interface ReservationDAO extends Dao<Reservation> {

    boolean isReservationDateTaken(String reservationDate);
}
