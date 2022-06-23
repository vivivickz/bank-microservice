package com.abc.userregistration.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import javax.persistence.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "address")
@Setter
@Getter
@ToString
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer addressId;

    @NotNull(message = "Door Number should not be null")
    private Integer doorNumber;

    @NotBlank(message = "street  should not be null")
    private String street;

    @NotBlank(message = "area  should not be null")
    private String area;

    @NotBlank(message = " city should not be null")
    private String city;

    @NotBlank(message = "State Code  should not be null")
    @Size(max = 2)
    private String stateCode;

    @NotNull(message = "Pincode should not be null")
    private Integer pincode;
}
