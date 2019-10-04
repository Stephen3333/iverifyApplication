package com.iverify.iverifyApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.iverify.iverifyapp")
@EnableTransactionManagement
//@EntityScan(basePackages="com.javainfinite")
public class IverifyAppApplication {
    
    public static void main(String[] args) {
            SpringApplication.run(IverifyAppApplication.class, args);
    }
}
