package ba.unsa.etf.rpr;


import ba.unsa.etf.rpr.dao.CustomerImpl;
import ba.unsa.etf.rpr.dao.ReservationImpl;
import ba.unsa.etf.rpr.dao.TreatmentImpl;
import ba.unsa.etf.rpr.exceptions.ReservationException;

import java.sql.SQLException;
import java.util.Scanner;

public class AppTerminal {
    private static CustomerImpl customerdao;
    private static ReservationImpl reservationdao;

    private static TreatmentImpl treatmentdao;
    private static Scanner ulaz;
    public static void main(String[] args) throws SQLException, ReservationException {

        customerdao = CustomerImpl.getInstance();
        ulaz = new Scanner(System.in);
        reservationdao = ReservationImpl.getInstance();
        treatmentdao = TreatmentImpl.getInstance();
        System.out.println("Welcome to SkinCare Pro!");
        System.out.println("------------------------");
        System.out.println("Please enter an option: ");
        System.out.println("\n1 - Log In\n2 - SignUp\n0 - end");
        int option = ulaz.nextInt();
        if (ulaz.hasNextLine()) ulaz.nextLine();
        switch(option){
            case 1:
                logIn();
                break;
            case 2:
                signUp();
                break;
            case 0:
                break;
            default:
                System.out.println("unknown option");
        }
        if(option==1) {
            System.out.println("Please enter an option: ");
            System.out.println("\n1 - Information about my reservations\n2- Information about your booked treatments\n3 - Book your treatment\n0 - end");
            int option1 = ulaz.nextInt();
            switch (option1) {
                case 1:
                    infoRes();
                    break;
                case 2:
                    infoTr(); break;
                case 3:
                    bookTreatment(); break;
                case 0:
                    break;

            }
        }
        else if(option == 2){
            System.out.println("Now log in with your data: ");
            logIn();
            System.out.println("Do you want to book your treatment?");
            System.out.println("1 - Yes\n2- No");
            int option2 = ulaz.nextInt();
            switch (option2){
                case 1:

                    break;
                case 2: break;
            }
        }


    }

    private static void infoTr() {
        System.out.println("Enter your unique id:");
        int id = ulaz.nextInt();
        for (Treatment treatment : treatmentdao.get(id))
        {

            System.out.println("Info's about treatments:\nName of the treatment: " +treatment.getName()+"\nDuration: "+treatment.getDuration()+"\nPrice: "+treatment.getPrice());

        }
    }
    private static void bookTreatment(){
        int id=0;
        Reservation reservation = bookTreatmentD(id);
        reservationdao.save(reservation);
    }
    private static Reservation bookTreatmentD(int id) {
        String status;
        int res_id,treat_id1 = 0,cus_id1;
        String cus_id= new String();
        String treat_id= new String();
        String date;
        String time;


        System.out.println("Unique ID of reservation: ");
        res_id = Integer.parseInt(ulaz.nextLine());
        System.out.println("Enter your username again: ");
        customerdao.getCustomerIdByUsername(cus_id);
        cus_id = ulaz.nextLine();
        System.out.println("Name of treatment: ");
        treatmentdao.getTreatmentIDByName(treat_id);
        treat_id = ulaz.nextLine();
        System.out.println("Date: ");
        date = ulaz.nextLine();
        System.out.println("Time: ");
        time = ulaz.nextLine();
        System.out.println("Confirm reservation(enter 'confirm'): ");
        status = ulaz.nextLine();
        cus_id1 = Integer.parseInt(cus_id);
        treat_id = String.valueOf(Integer.parseInt(treat_id));
        return (new Reservation(res_id,cus_id1,treat_id1,date,time,status));

    }


    private static void infoRes() throws ReservationException {
        System.out.println("Enter your unique id:");
        int id = ulaz.nextInt();
        for (Reservation reservation : reservationdao.get(id))
        {

            System.out.println("Info about reservations:\nReservation date: " + reservation.getReservationDate() +"\nTime of reservation: "+ reservation.getTime() +"\nStatus: "+reservation.getStatus());


        }
    }

    private static void signUp(){
        int id=0;
        Customer customer = signUp1(id);
        customerdao.save(customer);
    }
    private static Customer signUp1(int id) {
        String user,pass,name,surname,mail,tel;

        System.out.println("username:");
        user = ulaz.nextLine();
        System.out.println("password:");
        pass = ulaz.nextLine();
        System.out.println("First Name: ");
        name = ulaz.nextLine();
        System.out.println("Last Name: ");
        surname = ulaz.nextLine();
        System.out.println("E-mail");
        mail = ulaz.nextLine();
        System.out.println("Phone Number");
        tel = ulaz.nextLine();
        System.out.println("Welcome " + user + "!" );
        return (new Customer(id,user,pass,name,surname,mail,tel));
    }

    private static void logIn() {
        System.out.println("Log In");
        System.out.println("--------");
        System.out.println("Username: ");
        String username=ulaz.next();
        System.out.println("Password: ");
        String password = ulaz.next();
        if(customerdao.authenticateUser(username,password)) {
            System.out.println("Welcome " + username + "!");
        }
        else {
            System.out.println("Error! You either don't have account or you entered wrong data!");
        }

    }


    }
