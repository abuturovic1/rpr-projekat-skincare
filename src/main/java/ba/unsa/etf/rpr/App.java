package ba.unsa.etf.rpr;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.Scanner;
import java.sql.*;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class App extends Application{ //extends Application
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/reg.fxml"));
        primaryStage.setTitle("Registration");
        primaryStage.setScene(new Scene(root,USE_COMPUTED_SIZE,USE_COMPUTED_SIZE));
        primaryStage.setResizable(false);
        primaryStage.show();

    }
/*
    private static CustomerImpl customerdao;
    private static ReservationImpl reservationdao;

    private static TreatmentImpl treatmentdao;

    private static Scanner ulaz;
    public static void main(String[] args) throws SQLException {

        customerdao = CustomerImpl.getInstance();
        ulaz = new Scanner(System.in);
        reservationdao = ReservationImpl.getInstance();
        treatmentdao = TreatmentImpl.getInstance();

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
            do {
                System.out.println("Tabela Reservation\nUnesite opciju:\n1 - pretraga svih rezervacija\n2 - unos\n3 - izmjena\n4 - brisanje\n5 - pretraga po id-u korisnika\n0 - kraj programa ");

                opcija2 = ulaz.nextInt();
                if (ulaz.hasNextLine()) ulaz.nextLine();
                switch (opcija2) {
                    case 1:
                        pretragaSvihR(); //radi
                        break;
                    case 2:
                        unosR(); //ne radi , radi kad obrisem u bazi foreign keys...
                        break;
                    case 3:
                        izmjenaR(); //ne radi
                        break;
                    case 4:
                        brisanjeR(); //radi
                        break;
                    case 5:
                        pretragaRezervacijeKorisnika();//radi
                    case 0:
                        break;
                    default:
                        System.out.println("Nepoznata opcija!");
                }
            }while(opcija2!=0);
        }
        else if(brTabele == 3) {
            do {
                System.out.println("Tabela Treatment\nUnesite opciju:\n1 - unos\n2 - pretraga svih zakazanih tretmana\n3 - izmjena\n4 - brisanje\n5 - pretraga po id-u korisnika\n0 - kraj programa ");
                opcija3 = ulaz.nextInt();
                if (ulaz.hasNextLine()) ulaz.nextLine();
                switch(opcija3){
                    case 1: 
                        unosT();
                        break;
                    case 2: 
                        pretragaSvihT();
                        break;
                    case 3: 
                        izmjenaT();
                        break;
                    case 4: 
                        brisanjeT();
                        break;

                    case 5:
                        pretragaTretmanaKorisnika();
                        break;
                    case 0: break;
                    default:
                        System.out.println("Nepoznata opcija!");
                }
            }while(opcija3!=0);
        }
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


    //Za Reservation:
    //Ovo ce ispisati samo datum rezervacije, vrijeme i status
    private static void pretragaSvihR() {
        for(Reservation reservation : reservationdao.getAll()){
            System.out.println(" " + reservation.getReservationDate() + " " +reservation.getTime()+" "+reservation.getStatus());
        }


    }

    private static void pretragaRezervacijeKorisnika() {
        System.out.println("Unesite id korisnika čije informacije o rezervaciji želite vidjeti:");
        int id = ulaz.nextInt();
        for (Reservation reservation : reservationdao.get(id)) //pretraga info o korisniku koji ima rez za uneseni id
        {

            System.out.println("Informacije o korisniku:\nDatum rezervacije: " + reservation.getReservationDate() +"\nVrijeme rezervacije: "+ reservation.getTime() +"\nStatus rezervacije: "+reservation.getStatus());


        }
    }
    private static void brisanjeR() {
        int id_rez;

        System.out.println("Unesi ID rezervacije koju brišete: ");
        id_rez = ulaz.nextInt();
        Reservation reservation = new Reservation(id_rez,0,0,null,null,"");
        reservationdao.delete(reservation);

    }
    private static void unosR(){
        int id=0;
        Reservation reservation = unosRD(id);
        reservationdao.save(reservation);
    }
    private static Reservation unosRD(int id) {
        String status;
        int res_id,treat_id, cus_id;
        String date;
        String time;


        System.out.println("Unesite ID rezervacije: ");
        res_id = Integer.parseInt(ulaz.nextLine());   //parseInt -> (convert) a string representation of an integer into an actual integer value
        System.out.println("Unesite ID korisnika: ");
        cus_id = Integer.parseInt(ulaz.nextLine());
        System.out.println("Unesite ID tretmana: ");
        treat_id = Integer.parseInt(ulaz.nextLine());
        System.out.println("Unesite datum: ");
        date = ulaz.nextLine();
        System.out.println("Unesite vrijeme: ");
        time = ulaz.nextLine();
        System.out.println("Status: ");
        status = ulaz.nextLine();
        return (new Reservation(res_id,cus_id,treat_id,date,time,status));

    }

    private static void izmjenaR() {
        int id;
        System.out.println("Unesite ID rezervacije koju mijenjate: ");
        id = ulaz.nextInt();
        Reservation reservation = unosRD(id);
        reservationdao.update(reservation);

    }
    //Za Treatment:
    private static void unosT() {
    }
    private static void pretragaSvihT() {
        for(Treatment treatment : treatmentdao.getAll()){
            System.out.println("\nNaziv tretmana: " + treatment.getName()+ "\nOpis tretmana: " +treatment.getDescription()+"\nTrajanje tretmana: "+ treatment.getDuration() +"\nCijena tretmana: " +treatment.getPrice());
        }



    }
    private static void izmjenaT() {
        String nazivT;
        System.out.println("Unesi naziv tretmana: ");
        nazivT = ulaz.next();
        if(ulaz.hasNextLine()) ulaz.nextLine();


    }
    private static void brisanjeT() {
        int id_tr;

        System.out.println("Unesi ID tretmana koji želite obrisati: ");
        id_tr = ulaz.nextInt();
        Treatment treatment = new Treatment(id_tr,0," "," ",0,0);
        treatmentdao.delete(treatment);

    }
    private static void pretragaTretmanaKorisnika() {
        System.out.println("Unesite id korisnika čije informacije o rezervaciji želite vidjeti:");
        int id = ulaz.nextInt();
        for (Treatment treatment : treatmentdao.get(id)) //pretraga info o korisniku koji ima rez za uneseni id
        {

            System.out.println("Informacije o tretmanu odabranog korisnika:\nNaziv tretmana: " +treatment.getName()+"\nTrajanje tretmana: "+treatment.getDuration()+"\nCijena tretmana: "+treatment.getPrice());

        }
    }
*/

}

