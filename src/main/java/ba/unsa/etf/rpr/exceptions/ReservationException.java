package ba.unsa.etf.rpr.exceptions;

/**
 * A user defined class for handling exceptions related to reservations.
 */
public class ReservationException extends Exception{
    public ReservationException(String mess,Exception cause){
        super(mess,cause);
    }
    public ReservationException(String mess){
        super(mess);
    }
}
