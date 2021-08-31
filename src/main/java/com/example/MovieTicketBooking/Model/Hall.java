package com.example.MovieTicketBooking.Model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "Hall")
public class Hall {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid",strategy = "uuid")
    private String hallID;
    @Column(name = "HALL_NAME")
    private String name;
    @Column(name = "LOCATION")
    private String location;
    @Column(name = "PHONE_NUMBER")
    private String phoneNUmber;
    @Column(name = "EMAIL")
    private String email;
    private String image;
    private String imagePath;
    public Hall() {
    }

    public Hall(String hallID, String name, String location, String phoneNUmber, String email, String image, String imagePath) {
        this.hallID = hallID;
        this.name = name;
        this.location = location;
        this.phoneNUmber = phoneNUmber;
        this.email = email;
        this.image = image;
        this.imagePath = imagePath;
    }

    public String getHallID() {
        return hallID;
    }

    public void setHallID(String hallID) {
        this.hallID = hallID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhoneNUmber() {
        return phoneNUmber;
    }

    public void setPhoneNUmber(String phoneNUmber) {
        this.phoneNUmber = phoneNUmber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
