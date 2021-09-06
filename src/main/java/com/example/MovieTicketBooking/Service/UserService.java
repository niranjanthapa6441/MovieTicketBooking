package com.example.MovieTicketBooking.Service;

import com.example.MovieTicketBooking.Model.*;
import com.example.MovieTicketBooking.Repository.RoleRepository;
import com.example.MovieTicketBooking.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    public void saveUser(Users user){
        Role roleUser = roleRepository.findByName("Admin");
        user.addRole(roleUser);
        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users=null;
        if (users == null){
            throw new UsernameNotFoundException("Not found");
        }
        return new CustomUsersDetail(users);
    }
}
