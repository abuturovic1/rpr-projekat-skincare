package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.exceptions.ReservationException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface Dao <T>{
    ArrayList<T> get(int id) throws ReservationException;

    List<T> getAll() throws ReservationException;
    void save(T t);

    void update(T t);

    void delete (T t);
}
