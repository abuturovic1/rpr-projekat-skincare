package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.exceptions.ReservationException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * This is the generic interface that defines some basic operations for data access
 * @param <T> The type of object for which data access operations are specified.
 */
public interface Dao <T>{
    ArrayList<T> get(int id) throws ReservationException;

    List<T> getAll() throws ReservationException;
    void save(T t);

    void update(T t);

    void delete (T t);
}
