package com.example.MovieTicketBooking.Repository;

import com.example.MovieTicketBooking.Model.Role;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role,Long> {
    @Query("Select r FROM Role r where r.name = ?1")
    public Role findByName(String role_name);
}
