package ba.unsa.etf.rpr.controllers;
import ba.unsa.etf.rpr.CustomerImpl;
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
    private CustomerImpl customerDAO;
    @FXML
    public void initialize() {
        // Initialize ComboBox with treatment names
        treatmentComboBox.getItems().addAll("Acne Treatment", "Microdermabrasion", "Chemical Peel");

        // Initialize the reservationDAO
        try {
            reservationDAO = ReservationImpl.getInstance();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void reserveButtonClicked() {
       // String customerID = customerIDField.getText();
        String username = customerIDField.getText();
        String selectedTreatment = treatmentComboBox.getValue();
        String reservationDate = reservationDatepicker.getValue().toString();
       String time = timeField.getText();

        try {
            reservationDAO = ReservationImpl.getInstance();
            treatmentDAO = TreatmentImpl.getInstance();
            customerDAO = CustomerImpl.getInstance();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        int customerID = customerDAO.getCustomerIdByUsername(username);
        if (reservationDAO.isReservationDateTaken(reservationDate)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("The selected date is already booked. Please choose another date.");
            alert.showAndWait();
            return;
        }


        // Create a Reservation object and populate its properties
        Reservation reservation = new Reservation();
        reservation.setCustomerID(Integer.parseInt(String.valueOf(customerID))); // Convert to int
        reservation.setTreatmentID(getTreatmentID(selectedTreatment));
        reservation.setReservationDate(reservationDate);
        reservation.setTime(time);
        reservation.setStatus("Pending"); // Default status
        //String selectedTreatment = treatmentComboBox.getValue();
        int treatmentID = treatmentDAO.getTreatmentIDByName(selectedTreatment);

        // Save the reservation
        reservationDAO.save(reservation);
        Alert alert;
        alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Message");
        alert.setHeaderText(null);
        alert.setContentText("You successfully booked your treatment!");
        alert.showAndWait();

        // Show a confirmation or message to the user
        //System.out.println("Reservation made for customer " + customerID);
    }

    private int getTreatmentID(String treatmentName) {
        // You might need to call TreatmentSQLImplementation to retrieve the treatment ID by name
        return 0; // Placeholder value, replace with actual logic
    }


}




