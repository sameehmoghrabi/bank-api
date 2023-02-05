package dev.moghrabi.sameeh.bankapi.repository;

import dev.moghrabi.sameeh.bankapi.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
