package dev.moghrabi.sameeh.bankapp.service;

import dev.moghrabi.sameeh.bankapp.exception.CustomerNotFoundException;
import dev.moghrabi.sameeh.bankapp.model.Customer;
import dev.moghrabi.sameeh.bankapp.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer getCustomerById(Long customerId) {
        return customerRepository.findById(customerId).orElseThrow(() -> new CustomerNotFoundException(customerId));
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
}
