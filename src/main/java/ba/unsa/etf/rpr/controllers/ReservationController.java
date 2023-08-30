package ba.unsa.etf.rpr.controllers;
import ba.unsa.etf.rpr.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.List;

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
        int treatmentID = treatmentDAO.getTreatmentIDByName(selectedTreatment);
        Reservation reservation = new Reservation();
        reservation.setCustomerID(Integer.parseInt(String.valueOf(customerID)));
        reservation.setTreatmentID(getTreatmentID(selectedTreatment));
        reservation.setReservationDate(reservationDate);
        reservation.setTime(time);
        reservation.setStatus("Pending");
        reservationDAO.save(reservation);
    if(selectedTreatment == "Acne Treatment") {
    Treatment treatment = new Treatment();
    treatment.setCustomer_id(Integer.parseInt(String.valueOf(customerID)));
    treatment.setTreatment_id(getTreatmentID(selectedTreatment));
    treatment.setName(selectedTreatment);
    treatment.setDescription("Targeted care for acne-prone skin, includes extractions and LED therapy.");
    treatment.setDuration(1);
    treatment.setPrice(50.0);
    treatmentDAO.save(treatment);
}
    else if(selectedTreatment == "Microdermabrasion"){
        Treatment treatment = new Treatment();
        treatment.setCustomer_id(Integer.parseInt(String.valueOf(customerID)));
        treatment.setTreatment_id(getTreatmentID(selectedTreatment));
        treatment.setName(selectedTreatment);
        treatment.setDescription("Gentle skin exfoliation for smoother, scar-free skin.");
        treatment.setDuration(2);
        treatment.setPrice(100.0);
        treatmentDAO.save(treatment);

    }
    else if(selectedTreatment == "Chemical Peel"){
        Treatment treatment = new Treatment();
        treatment.setCustomer_id(Integer.parseInt(String.valueOf(customerID)));
        treatment.setTreatment_id(getTreatmentID(selectedTreatment));
        treatment.setName(selectedTreatment);
        treatment.setDescription("Exfoliating solutions reveal youthful, smoother skin layers.");
        treatment.setDuration(1);
        treatment.setPrice(60.0);
        treatmentDAO.save(treatment);

    }




        Alert alert;
        alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Message");
        alert.setHeaderText(null);
        alert.setContentText("You successfully booked your treatment!");
        alert.showAndWait();

    }

    private int getTreatmentID(String treatmentName) {
        // You might need to call TreatmentSQLImplementation to retrieve the treatment ID by name
        return 0; // Placeholder value, replace with actual logic
    }


}




