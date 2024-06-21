package com.example.csproj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

//@SpringBootApplication

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@EnableCaching
//@ComponentScan(basePackages = "")
public class CsprojApplication {

    public static void main(String[] args) {
        SpringApplication.run(CsprojApplication.class, args);
    }

}
