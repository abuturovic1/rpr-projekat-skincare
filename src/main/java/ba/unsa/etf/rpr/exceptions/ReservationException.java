package ba.unsa.etf.rpr.exceptions;

public class ReservationException extends Exception{
    public ReservationException(String mess,Exception cause){
        super(mess,cause);
    }
    public ReservationException(String mess){
        super(mess);
    }
}
