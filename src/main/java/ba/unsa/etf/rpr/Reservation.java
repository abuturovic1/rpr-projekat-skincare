package ba.unsa.etf.rpr;
import java.sql.Time;
import java.time.LocalTime;
import java.util.*;

/**
 * The Reservation class is regular Java Bean class and represents a reservation made by customer for a treatment
 */
public class Reservation {
    private int reservationID,customerID,treatmentID;
    private String status,reservationDate,time;

    /**
     * A constructor which constructs a new Reservation object with the provided information
     * @param reservationID unique ID of the reservation
     * @param customerID the ID of the customer making the reservation
     * @param treatmentID the ID of the treatment being reserved
     * @param reservationDate the date of the reservation
     * @param time the time of the reservation
     * @param status the status of the reservation
     */
    public Reservation(int reservationID,int customerID,int treatmentID,String reservationDate,String time,String status){
    this.reservationID=reservationID;
    this.customerID=customerID;
    this.treatmentID=treatmentID;
    this.reservationDate=reservationDate;
    this.time=time;
    this.status=status;

}

    /**
     * Empty Constructor which constucts new empty Reservation object
     */
    public Reservation(){}
    public int getReservationID() {
        return reservationID;
    }

    public void setReservationID(int reservationID) {
        this.reservationID = reservationID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getTreatmentID() {
        return treatmentID;
    }

    public void setTreatmentID(int treatmentID) {
        this.treatmentID = treatmentID;
    }

    public String getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(String reservationDate) {
        this.reservationDate = reservationDate;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
