package com.abc.userregistration.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Setter
@Getter
@ToString
public class PermanentAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int permanentAddressId;

    private Integer doorNumber;
    private String street;
    private String area;
    private String city;
    private String stateCode;
    private Integer pincode;
}
