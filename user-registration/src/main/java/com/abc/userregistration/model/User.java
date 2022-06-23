package com.abc.userregistration.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.*;


@Entity
@Table(name = "user")
@Setter
@Getter
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    private String firstName;

    @NotBlank(message = "Last name cannot be null")
    private String lastName;

    @NotBlank(message = "Date of birth should not be null")
    private String dob;

    private String gender;

    @Column(unique = true)
    @Email
    private String emailId;

    @NotBlank(message = "Password cannot be null")
    private String password;

    @Column(unique = true)
    @NotBlank(message = "Pan Number cannot be null")
    private String panNumber;

    @Column(unique = true)
    @NotNull(message = "Phone Number cannot be null")
    private Long phoneNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "current_address_id")
    private Address address;


    @OneToOne(cascade = CascadeType.ALL)
    private PermanentAddress permanentAddress;

}
