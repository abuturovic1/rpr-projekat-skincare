package ba.unsa.etf.rpr.controllers;
import ba.unsa.etf.rpr.ReservationImpl;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.sql.SQLException;
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


}


