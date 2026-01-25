package com.esther.fooddelivery;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class FooddeliveryApplication {
    public static void main(String[] args){
        SpringApplication.run(FooddeliveryApplication.class,args);
        log.info("Project has started successfully.... ");
    }
}
