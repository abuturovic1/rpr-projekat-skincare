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
        reservationdao = ReservationImpl.getInstance();

        //Standard menu
        int opcija1 = 0, opcija2 = 0, opcija3 = 0, brTabele;
        System.out.println("Unesi broj tabele : \n1 - Customer\n2 - Reservation\n3 - Treatment");
        brTabele = ulaz.nextInt();
        if (brTabele == 1) {
            do {
                System.out.println("Tabela Customer\nUnesite opciju:\n1 - pretraga\n2 - unos\n3 - izmjena\n4 - brisanje\n5 - pretraga svih korisnika\n0 - kraj programa ");

                opcija1 = ulaz.nextInt();
                if (ulaz.hasNextLine()) ulaz.nextLine();
                switch (opcija1) {
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
                    case 5:
                        pretragaSvih();
                    case 0:
                        break;
                    default:
                        System.out.println("Nepoznata opcija!");

                }
            } while (opcija1 != 0);

        } else if (brTabele == 2) {
            System.out.println("Tabela Reservation\nUnesite opciju:\n1 - pretraga\n2 - unos\n3 - izmjena\n4 - brisanje\n5 - pretraga po id-u korisnika\n0 - kraj programa ");

            opcija1 = ulaz.nextInt();
            if (ulaz.hasNextLine()) ulaz.nextLine();
            switch (opcija1) {
                case 1:
                    //pretragaR();
                    break;
                case 2:
                    //unosR();
                    break;
                case 3:
                    //izmjenaR();
                    break;
                case 4:
                    brisanjeR();
                    break;
                case 5:
                    pretragaRezervacijeKorisnika();
                case 0:
                    break;
                default:
                    System.out.println("Nepoznata opcija!");
            }
        }
    }

    private static void brisanjeR() {
        int id_rez,id_kor,id_tretmana;

        System.out.println("Unesi ID rezervacije koju brišete: ");
        id_rez = ulaz.nextInt();
        /*System.out.println("Unesi ID korisnika čiju rezervaciju brišete: ");
        id_kor = ulaz.nextInt();
        System.out.println("Unesi ID tretmana: ");
        id_tretmana=ulaz.nextInt();*/

        Reservation reservation = new Reservation(id_rez,0,0,null,null,"");
        reservationdao.delete(reservation);

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
    //Ovo ce ispisati samo datum rezervacije, vrijeme i status
    private static void pretragaRezervacijeKorisnika() {
        System.out.println("Unesite id korisnika čije informacije o rezervaciji želite vidjeti:");
        int id = ulaz.nextInt();
        for (Reservation reservation : reservationdao.get(id)) //pretraga info o korisniku koji ima rez za uneseni id
        {

            System.out.println("Informacije o korisniku:\nDatum rezervacije: " + reservation.getReservationDate() +"\nVrijeme rezervacije: "+ reservation.getTime() +"\nStatus rezervacije: "+reservation.getStatus());


        }
    }
}

