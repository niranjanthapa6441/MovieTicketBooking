package com.example.MovieTicketBooking.Model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "USERS")
public class Users {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name = "USER_ID")
    private String userID;
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
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();
    public Users() {
    }

    public Users(String userID,
                 String firstName,
                 String middleName,
                 String lastName,
                 String email,
                 String username,
                 String password,
                 String confirmPassword,
                 String phoneNumber) {
        this.userID = userID;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.phoneNumber = phoneNumber;
    }
    public void addRole(Role role){
        this.roles.add(role);
    }
}
