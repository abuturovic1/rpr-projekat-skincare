package ba.unsa.etf.rpr;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    private static CustomerImpl customerdao;
    private static ReservationImpl reservationdao;

    private static TreatmentImpl treatmentdao;
    public static void main( String[] args ) throws SQLException {

        customerdao = CustomerImpl.getInstance();
        reservationdao = ReservationImpl.getInstance();
        treatmentdao = TreatmentImpl.getInstance();


        int opcija = 0;
        do{
            System.out.println("Unesite opciju:\n1 - pretraga\n2 - unos\n3 - izmjena\n4 -brisanje\n0 - kraj programa ");
            Scanner ulaz = new Scanner(System.in);
            opcija = ulaz.nextInt();
            switch(opcija){
                case 1: pretraga(); break;
                case 2: unos(); break;
                case 3: izmjena(); break;
                case 4: brisanje(); break;
                case 0: break;
                default:
                    System.out.println("Nepoznata opcija");

            }
        } while(opcija!=0);


}
}

