package com.example.MovieTicketBooking.Model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "Customer")
public class Customer {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String customerID;
    @Column(nullable = false,name="FIRST_NAME")
    private String firstName;
    @Column(name="MIDDLE_NAME")
    private String middleName;
    @Column(nullable = false,name="LAST_NAME")
    private String lastName;
    @Column(nullable = false, unique = true,name="EMAIL")
    private String email;
    @Column(nullable = false,unique = true, name="USERNAME")
    private String username;
    @Column(nullable = false, name="PASSWORD")
    private String password;
    private String confirmPassword;
    @Column(nullable = false, unique = true,name="PHONE_NUMBER")
    private String phoneNumber;

    public Customer() {
    }

    public Customer(String customerID, String firstName, String middleName, String lastName, String email, String username, String password, String confirmPassword, String phoneNumber) {
        this.customerID = customerID;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.phoneNumber = phoneNumber;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
