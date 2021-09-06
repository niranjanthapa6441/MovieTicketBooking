package com.example.MovieTicketBooking.Model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
@Getter
@Setter
@Entity
@Table(name = "ROLE")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ROLE_ID")
    private Integer role_id;
    @Column(name = "name",nullable = false,unique = true)
    private String name;

    public Role() {
    }

    public Role(String role_name) {
        this.name = name;
    }

    public Role(Integer role_id) {
        this.role_id = role_id;
    }

    public Role(Integer role_id, String name) {
        this.role_id = role_id;
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
