package ba.unsa.etf.rpr;

import java.util.List;

public interface TreatmentDAO extends Dao<Treatment>{
List<Treatment>getbyTreatmentName(String name);
}
