package dev.moghrabi.sameeh.bankapp.repository;

import dev.moghrabi.sameeh.bankapp.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
