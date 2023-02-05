package dev.moghrabi.sameeh.bankapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import dev.moghrabi.sameeh.bankapi.constant.CommonConst;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double amount = 0.0;
    @JsonBackReference
    @ManyToOne()
    @JoinColumn(name = CommonConst.JoinColumn.ACCOUNT_ID, nullable = false)
    private Account account;

    public Transaction(Double amount, Account account) {
        this.account = account;
        this.amount = amount;
    }
}
