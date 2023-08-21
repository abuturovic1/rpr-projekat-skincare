package ba.unsa.etf.rpr;

import java.sql.SQLException;
import java.util.List;

import java.util.ArrayList;

public interface Dao <T>{
    T get(int id) throws SQLException;

    List<T> getAll();

    void save(T t);

    void update(T t);

    void delete (T t);
}
