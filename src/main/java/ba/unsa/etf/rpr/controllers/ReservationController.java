package ba.unsa.etf.rpr.controllers;
import ba.unsa.etf.rpr.ReservationImpl;
import ba.unsa.etf.rpr.TreatmentImpl;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.List;
import ba.unsa.etf.rpr.Reservation;

public class ReservationController {
    @FXML
    private Spinner<Integer> hourSpinner;

    @FXML
    private Spinner<Integer> minuteSpinner;
    @FXML
    private TextField customerIDField;

    @FXML
    private ComboBox<String> treatmentComboBox;

    @FXML
    private DatePicker reservationDatepicker;

    @FXML
    private TextField timeField;

    @FXML
    private Button reserveButton;

    private ReservationImpl reservationDAO;
    private TreatmentImpl treatmentDAO;
    @FXML
    public void initialize() {
        // Initialize ComboBox with treatment names
        treatmentComboBox.getItems().addAll("Treatment A", "Treatment B", "Treatment C");

        // Initialize the reservationDAO
        try {
            reservationDAO = ReservationImpl.getInstance();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void reserveButtonClicked() {
        String customerID = customerIDField.getText();
        String selectedTreatment = treatmentComboBox.getValue();
        String reservationDate = reservationDatepicker.getValue().toString();
       // String time = timeField.getText();
        int hour = hourSpinner.getValue();
        int minute = minuteSpinner.getValue();
        LocalTime reservationTime = LocalTime.of(hour, minute);
        try {
            reservationDAO = ReservationImpl.getInstance();
            treatmentDAO = TreatmentImpl.getInstance();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Create a Reservation object and populate its properties
        Reservation reservation = new Reservation();
        reservation.setCustomerID(Integer.parseInt(customerID)); // Convert to int
        reservation.setTreatmentID(getTreatmentID(selectedTreatment)); // You need to implement this method
        reservation.setReservationDate(reservationDate);
        reservation.setTime(reservationTime);
        reservation.setStatus("Pending"); // Default status
        //String selectedTreatment = treatmentComboBox.getValue();
        int treatmentID = treatmentDAO.getTreatmentIDByName(selectedTreatment);

        // Save the reservation
        reservationDAO.save(reservation);

        // Show a confirmation or message to the user
        System.out.println("Reservation made for customer " + customerID);
    }

    private int getTreatmentID(String treatmentName) {
        // You might need to call TreatmentSQLImplementation to retrieve the treatment ID by name
        return 0; // Placeholder value, replace with actual logic
    }

}




