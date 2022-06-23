package com.abc.accountservice;

import com.abc.accountservice.common.response.ApiResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.*;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableResourceServer
public class AccountServiceApplication {
	public static void main(String[] args) {

		SpringApplication.run(AccountServiceApplication.class, args);
	}
}
