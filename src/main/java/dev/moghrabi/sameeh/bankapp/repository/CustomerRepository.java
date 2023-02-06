package dev.moghrabi.sameeh.bankapp.repository;

import dev.moghrabi.sameeh.bankapp.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
