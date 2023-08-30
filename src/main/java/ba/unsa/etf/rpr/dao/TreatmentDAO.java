package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.Treatment;

import java.util.List;

/**
 * This interface defines data access operations for managing Treatment objects
 */
public interface TreatmentDAO extends Dao<Treatment> {
List<Treatment>getbyTreatmentName(String name);

    List<Treatment> getPreviousTreatments(int customerID);
}
