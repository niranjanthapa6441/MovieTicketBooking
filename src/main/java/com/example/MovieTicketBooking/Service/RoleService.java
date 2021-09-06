package com.example.MovieTicketBooking.Service;

import com.example.MovieTicketBooking.Model.Role;
import com.example.MovieTicketBooking.Repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoleService {
    private RoleRepository roleRepository;

    public Role findByName(String role_name){
        return roleRepository.findByName(role_name);
    }
}
