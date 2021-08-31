package com.example.MovieTicketBooking.Repository;

import com.example.MovieTicketBooking.Model.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterCustomerRepository extends CrudRepository<Customer,String> {
    @Query("Select u from Customer u where u.username=?1")
    Customer findByUsername(String username);
}
