package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.Dao;
import ba.unsa.etf.rpr.Treatment;

import java.util.List;

public interface TreatmentDAO extends Dao<Treatment> {
List<Treatment>getbyTreatmentName(String name);

    List<Treatment> getPreviousTreatments(int customerID);
}
