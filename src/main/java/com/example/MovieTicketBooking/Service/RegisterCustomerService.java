package com.example.MovieTicketBooking.Service;

import com.example.MovieTicketBooking.Model.CustomCustomerDetails;
import com.example.MovieTicketBooking.Model.Customer;
import com.example.MovieTicketBooking.Repository.RegisterCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class RegisterCustomerService implements UserDetailsService {
    @Autowired
    private RegisterCustomerRepository registerCustomerRepository;

    public RegisterCustomerService() {
    }

    public Iterable<Customer> getALlCustomers(){
        return registerCustomerRepository.findAll();
    }
    public void registerCustomer(Customer customer){
        registerCustomerRepository.save(customer);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customer= registerCustomerRepository.findByUsername(username);
        if (customer == null){
            throw new UsernameNotFoundException("Not found");
        }
        return new CustomCustomerDetails(customer);
    }
}

