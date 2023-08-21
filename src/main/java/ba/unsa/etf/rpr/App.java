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

    private static Scanner ulaz;
    public static void main( String[] args ) throws SQLException {

        customerdao = CustomerImpl.getInstance();
        reservationdao = ReservationImpl.getInstance();
        treatmentdao = TreatmentImpl.getInstance();
        ulaz = new Scanner(System.in);

        //Standardni meni
        int opcija = 0;
        do {
            System.out.println("Unesite opciju:\n1 - pretraga\n2 - unos\n3 - izmjena\n4 -brisanje\n0 - kraj programa ");

            opcija = ulaz.nextInt();
            switch (opcija) {
                case 1:
                    pretraga();
                    break;
                case 2:
                    unos();
                    break;
                case 3:
                    izmjena();
                    break;
                case 4:
                    brisanje();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Nepoznata opcija");

            }
        } while (opcija != 0);


    }

    private static void unos() {
        String idcustomer,korIme,lozinka,ime,prezime,mail,brTel;
        System.out.println("Unesite id korisnika: "); //korisnik ne treba da unosi id??
        idcustomer = ulaz.nextLine();
        System.out.println("Unesite username korisnika: ");
        korIme = ulaz.nextLine();
        System.out.println("Unesite lozinku korisnika: "); //ovo ne bi trebalo al ok ako je admin neki nesto
        lozinka = ulaz.nextLine();
        System.out.println("Unesite ime korisnika: ");
        ime = ulaz.nextLine();
        System.out.println("Unesite prezime korisnika: ");
        prezime = ulaz.nextLine();
        System.out.println("Unesite e-mail korisnika: ");
        mail = ulaz.nextLine();
        System.out.println("Unesite broj telefona korisnika: ");
        brTel = ulaz.nextLine();

    }


    private static void pretragaSvih(){
        for(Customer customer : customerdao.getAll())
            System.out.println("Imena i prezimena korisnika su: " +customer.getFirstName()+ " " +customer.getLastName());

    }
}

