package dev.moghrabi.sameeh.bankapp.configuration;

import dev.moghrabi.sameeh.bankapp.model.Customer;
import dev.moghrabi.sameeh.bankapp.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadCustomerDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadCustomerDatabase.class);

    @Bean
    CommandLineRunner initDatabase(CustomerRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Customer("Sameeh", "Moghrabi")));
            log.info("Preloading " + repository.save(new Customer("John", "Doe")));
        };
    }
}
