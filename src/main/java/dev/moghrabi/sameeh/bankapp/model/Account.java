package dev.moghrabi.sameeh.bankapp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import dev.moghrabi.sameeh.bankapp.constant.CommonConst;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double balance = 0.0;

    @JsonBackReference
    @ManyToOne()
    @JoinColumn(name = CommonConst.JoinColumn.CUSTOMER_ID, nullable = false)
    private Customer customer;

    @JsonManagedReference
    @OneToMany(mappedBy = "account")
    private List<Transaction> transactions;

    public Account(Double balance, Customer customer) {
        this.balance = balance;
        this.customer = customer;
    }

    public Account(Customer customer) {
        this.customer = customer;
    }
}
