package ba.unsa.etf.rpr;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.*;
public class App 
{
    private static CustomerImpl customerdao;
    private static ReservationImpl reservationdao;

    private static TreatmentImpl treatmentdao;

    private static Scanner ulaz;
    public static void main(String[] args) throws SQLException {

        customerdao = CustomerImpl.getInstance();
        ulaz = new Scanner(System.in);

        //Standard menu
        int opcija1 = 0,opcija2 = 0,opcija3 = 0;
        do {
            System.out.println("Unesite opciju:\n1 - pretraga\n2 - unos\n3 - izmjena\n4 - brisanje\n5 - pretraga svih korisnika\n0 - kraj programa ");

            opcija1 = ulaz.nextInt();
            if(ulaz.hasNextLine()) ulaz.nextLine();
            switch (opcija1) {
                case 1:
                    pretraga(); //radi
                    break;
                case 2:
                    unos(); //ne radi
                    break;
                case 3:
                    izmjena(); // ne radi
                    break;
                case 4:
                    brisanje(); //radi
                    break;
                case 5:
                    pretragaSvih(); //radi
                case 0:
                    break;
                default:
                    System.out.println("Nepoznata opcija!");

            }
        } while (opcija1 != 0);


    }

    private static void brisanje() {
        int id;
        System.out.println("Unesi ID korisnika kojeg brišete: ");
        id = ulaz.nextInt();
        Customer customer = new Customer(id,"","","","","","");
        customerdao.delete(customer);

    }

    private static void pretraga() {
        System.out.println("Unesite id korisnika kojeg želite pretražiti:" );
        int id = ulaz.nextInt();
        for(Customer customer : customerdao.get(id))
        System.out.println("Ime i prezime tog korisnika je: " + customer.getFirstName()+" "+customer.getLastName());
    }

    private static void izmjena() {
        int id;
        System.out.println("ID korisnika kojeg mijenjate: ");
        id = ulaz.nextInt();
        if(ulaz.hasNextLine()) ulaz.nextLine();
        Customer customer = unosD(id);
        customerdao.update(customer);


    }
        private static void unos(){
        int id=0;
        Customer customer = unosD(id);
        customerdao.save(customer);
        }
    private static Customer unosD(int id) {
        String korIme,lozinka,ime,prezime,mail,brTel;

        System.out.println("Unesite username korisnika: ");
        korIme = ulaz.nextLine();
        System.out.println("Unesite lozinku korisnika: ");
        lozinka = ulaz.nextLine();
        System.out.println("Unesite ime korisnika: ");
        ime = ulaz.nextLine();
        System.out.println("Unesite prezime korisnika: ");
        prezime = ulaz.nextLine();
        System.out.println("Unesite e-mail korisnika: ");
        mail = ulaz.nextLine();
        System.out.println("Unesite broj telefona korisnika: ");
        brTel = ulaz.nextLine();
        return (new Customer(id,korIme,lozinka,ime,prezime,mail,brTel));
    }


    private static void pretragaSvih(){
        for(Customer customer : customerdao.getAll())
            System.out.println("Imena i prezimena korisnika su: " +customer.getFirstName()+ " " +customer.getLastName());

    }
}

