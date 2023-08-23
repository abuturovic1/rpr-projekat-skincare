package ba.unsa.etf.rpr;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TreatmentImpl implements TreatmentDAO{
private Connection connection;
    private static TreatmentImpl instance = null;
    private PreparedStatement pretragaK_ps,izbrisi_ps,pretraziSve;


    private TreatmentImpl() throws SQLException{
        String url = "jdbc:mysql://sql.freedb.tech:3306/freedb_rpr baza";
        String username="freedb_abuturovic1";
        String pass = System.getenv("DB_PASSWORD");
        connection = DriverManager.getConnection(url,username,pass);
        pretragaK_ps = connection.prepareStatement("SELECT * FROM Treatment WHERE customer_id = ? ");
        izbrisi_ps=connection.prepareStatement("DELETE FROM Treatment WHERE treatment_id = ?");
        pretraziSve = connection.prepareStatement("SELECT * FROM Treatment");



    }


    public static TreatmentImpl getInstance()throws SQLException {
        if(instance == null) instance = new TreatmentImpl();
        return instance;
    }
    public static void removeInstance () throws SQLException{
        if(instance == null) return;
        instance.connection.close();
        instance=null;
    }

   /* @Override
    public ArrayList<Treatment> get(int id) {
        return null;
    }*/
    @Override
    public ArrayList<Treatment> get(int customerID){
      ArrayList<Treatment> treatments = new ArrayList<>();
      try{
          pretragaK_ps.setInt(1,customerID);
          ResultSet rs = pretragaK_ps.executeQuery();
          while(rs.next()){
              Treatment treatment = new Treatment();
              treatment.setTreatment_id(rs.getInt("treatment_id"));
              treatment.setCustomer_id(rs.getInt("customer_id"));
              treatment.setName(rs.getString("name"));
              treatment.setDescription(rs.getString("description"));
              treatment.setDuration(rs.getInt("duration"));
              treatment.setPrice(rs.getDouble("price"));
              treatments.add(treatment);
          }
      } catch (SQLException e) {
          throw new RuntimeException(e);
      }
      return treatments;
    }

   @Override
    public List<Treatment> getAll() {
       ArrayList<Treatment>treatments = new ArrayList<Treatment>();
        try{
            ResultSet rs = pretraziSve.executeQuery();
            while(rs.next()){
                treatments.add(new Treatment(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getDouble(6)));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return treatments;
    }

    @Override
    public void save(Treatment treatment) {

    }



    @Override
    public void update(Treatment treatment) {

    }

    @Override
    public void delete(Treatment treatment) {
        try{
            izbrisi_ps.setInt(1,treatment.getTreatment_id());
            izbrisi_ps.execute();

        }catch(SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public List<Treatment> getbyTreatmentName(String name) {
        return null;
    }
}
