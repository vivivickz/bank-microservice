package com.abc.authenticationservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@Entity
@Table(name="user_credential")
@NoArgsConstructor
public class JwtRequest {
    @Id
    String emailId;
    String password;
}
