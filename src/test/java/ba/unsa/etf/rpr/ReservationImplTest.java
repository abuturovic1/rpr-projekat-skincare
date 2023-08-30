package ba.unsa.etf.rpr;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
public class ReservationImplTest {
    @Mock
    private PreparedStatement pretragaK_ps;
    @Mock
    private PreparedStatement sveRezervacije_ps;
    @Mock
    private PreparedStatement noviId;
    @Mock
    private PreparedStatement dodaj_ps;
    @Mock
    private PreparedStatement izmijeni_ps;
    @Mock
    private PreparedStatement brisanje_ps;
    @Mock
    private PreparedStatement datum_ps;
    private ReservationImpl reservationDAO;
}

