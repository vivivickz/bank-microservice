package com.abc.accountservice.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "account_summary")
@Setter
@Getter
@ToString
public class Account {

    @Id
    private long accountNumber;
    @Column(unique = true)
    private int userId;
    private double currentBalance;
    private String lastName;

}
