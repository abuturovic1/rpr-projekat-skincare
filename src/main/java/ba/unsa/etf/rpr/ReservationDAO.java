package ba.unsa.etf.rpr;

import java.util.List;

public interface ReservationDAO extends Dao<Reservation>{

    boolean isReservationDateTaken(String reservationDate);
}
