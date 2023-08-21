package ba.unsa.etf.rpr;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TreatmentImpl implements TreatmentDAO{
private Connection connection;
    private static TreatmentImpl instance = null;
    public static TreatmentImpl getInstance()throws SQLException {
        if(instance == null) instance = new TreatmentImpl();
        return instance;
    }
    public static void removeInstance () throws SQLException{
        if(instance == null) return;
        instance.connection.close();
        instance=null;
    }
    @Override
    public ArrayList<Treatment> get(int id) {
        return null;
    }

    @Override
    public List<Treatment> getAll() {
        return null;
    }

    @Override
    public void save(Treatment treatment) {

    }



    @Override
    public void update(Treatment treatment) {

    }

    @Override
    public void delete(Treatment treatment) {

    }

    @Override
    public List<Treatment> getbyTreatmentName(String name) {
        return null;
    }
}
