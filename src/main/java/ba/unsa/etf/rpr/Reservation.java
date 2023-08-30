package ba.unsa.etf.rpr;
import java.sql.Time;
import java.time.LocalTime;
import java.util.*;

public class Reservation {  //javabean class
    private int reservationID,customerID,treatmentID;
    private String status,reservationDate,time;

public Reservation(int reservationID,int customerID,int treatmentID,String reservationDate,String time,String status){
    this.reservationID=reservationID;
    this.customerID=customerID;
    this.treatmentID=treatmentID;
    this.reservationDate=reservationDate;
    this.time=time;
    this.status=status;

}
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
