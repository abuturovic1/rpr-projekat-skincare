package ba.unsa.etf.rpr;

import java.util.Date;

/**
 * The Customer class is a regular Java Bean class which represents a customer in a system
 */

public class Customer {
    private int customerID;
    private String username;
    private String password;

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    /**
     * Constructor - constructs a new Customer object with the provided information
     * @param customerID unique ID of the customer
     * @param username username of the customer
     * @param password password of the customer
     * @param firstName the first name of the customer
     * @param lastName the last name of the customer
     * @param email the email adress of the customer
     * @param phoneNumber the phone number of the customer
     */
    public Customer(int customerID,String username,String password,String firstName, String lastName, String email, String phoneNumber){
    this.username=username;
    this.password=password;
    this.customerID=customerID;
    this.firstName=firstName;
    this.lastName=lastName;
    this.email=email;
    this.phoneNumber=phoneNumber;


}

  /*  @Override
    public String toString() {
        return "Customer{" +
                "customerID=" + customerID +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }*/

    /**
     * Empty Constructor that constructs a new empty Customer object
     */
    public Customer(){}



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }



}
