package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.dao.ReservationImpl;
import org.mockito.Mock;

import java.sql.PreparedStatement;

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

