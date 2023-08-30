package ba.unsa.etf.rpr;

import javax.swing.plaf.nimbus.State;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class TreatmentImpl implements TreatmentDAO{
private Connection connection;
    private static TreatmentImpl instance = null;
    private PreparedStatement pretragaK_ps,izbrisi_ps,pretraziSve,izmijeni_ps,pretraziPoImenu_ps,dodajTretman,noviId;


    private TreatmentImpl() throws SQLException{
        Properties properties = new Properties();

        try{
            properties.load(ClassLoader.getSystemResource("application.properties").openStream());
            String url = properties.getProperty("db.url");
            String username = properties.getProperty("db.username");
            String pass = properties.getProperty("db.password");
            connection = DriverManager.getConnection(url,username,pass);
        }catch(IOException e){
            e.printStackTrace();
        }
        pretragaK_ps = connection.prepareStatement("SELECT * FROM Treatment WHERE customer_id = ? ");
        izbrisi_ps=connection.prepareStatement("DELETE FROM Treatment WHERE treatment_id = ?");
        pretraziSve = connection.prepareStatement("SELECT * FROM Treatment");
        //update po nazivu tretmana:
        izmijeni_ps = connection.prepareStatement("UPDATE Treatment SET treatment_id = ? , customer_id = ?, description = ? , duration = ? , price = ?, WHERE name = ?");
        pretraziPoImenu_ps = connection.prepareStatement("SELECT treatment_id FROM Treatment WHERE name = ?");
        dodajTretman = connection.prepareStatement("INSERT INTO Treatment VALUES (?,?,?,?,?,?)");

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
        try{
            Statement alterStatement = connection.createStatement();
            String alterSql = "ALTER TABLE Treatment MODIFY treatment_id INT AUTO_INCREMENT";
            alterStatement.executeUpdate(alterSql);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try{
            dodajTretman.setInt(1,treatment.getTreatment_id());
            dodajTretman.setInt(2,treatment.getCustomer_id());
            dodajTretman.setString(3,treatment.getName());
            dodajTretman.setString(4,treatment.getDescription());
            dodajTretman.setInt(5,treatment.getDuration());
            dodajTretman.setDouble(6,treatment.getPrice());
            dodajTretman.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }



    @Override
    public void update(Treatment treatment) {
try{
    izmijeni_ps.setString(6,treatment.getName()); //name
    izmijeni_ps.setInt(1,treatment.getTreatment_id());
    izmijeni_ps.setInt(2,treatment.getCustomer_id());
    izmijeni_ps.setString(3,treatment.getDescription());
    izmijeni_ps.setInt(4,treatment.getDuration());
    izmijeni_ps.setDouble(5,treatment.getPrice());

}catch(SQLException e){
    e.printStackTrace();
}
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

    public int getTreatmentIDByName(String treatmentName) {
        try {
            pretraziPoImenu_ps.setString(1, treatmentName);
            ResultSet rs = pretraziPoImenu_ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("treatment_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1; // Treatment not found
    }

    @Override
    public List<Treatment> getbyTreatmentName(String name) {
        return null;
    }

    @Override
    public List<Treatment> getPreviousTreatments(int customerID) {
        List<Treatment> previousTreatments = new ArrayList<>();

        try {
            String query = "SELECT * FROM Treatment WHERE customer_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, customerID);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Treatment treatment = new Treatment();
                treatment.setTreatment_id(resultSet.getInt("treatment_id"));
                treatment.setCustomer_id(resultSet.getInt("customer_id"));
                treatment.setName(resultSet.getString("name"));
                // Set other treatment attributes here

                previousTreatments.add(treatment);
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return previousTreatments;
    }
}
   /* @Override
    public List<Treatment> getbyTreatmentName(String name) {
        return null;
    }*/

