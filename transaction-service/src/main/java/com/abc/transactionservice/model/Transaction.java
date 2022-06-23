package com.abc.transactionservice.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;



import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import java.util.Date;
import java.util.List;


@Entity
@Table(name="transaction_detail")
@Setter
@Getter
@ToString
public class Transaction  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer transactionId;

    private Integer userId;
    private Date transactionDate;
    private Long senderAccountNumber;
    private Long receiverAccountNumber;
    private String remarks;


    @Positive(message = "Transfer amount must be positive")
    @Min(value = 999, message = "amount must be larger than 999")
    private Double amount;

}
