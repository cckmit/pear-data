package com.pear.data.master;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class PearDataMasterApplication {

    public static void main(String[] args) {
        SpringApplication.run(PearDataMasterApplication.class, args);
    }

}
