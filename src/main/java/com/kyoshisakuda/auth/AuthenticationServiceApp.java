package com.kyoshisakuda.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AuthenticationServiceApp {

    public static void main(String[] args) {
        SpringApplication.run(AuthenticationServiceApp.class, args);
    }

}
