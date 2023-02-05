package dev.moghrabi.sameeh.bankapi.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String surname;

    //could not use Set<Account>, had infinite recursion problem even with applying JsonBackReference
    @JsonManagedReference
    @OneToMany(mappedBy = "customer")
    private List<Account> accounts;

    public Customer(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
}
