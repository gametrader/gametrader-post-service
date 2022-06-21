package com.gametrader.gametraderpostservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class GametraderPostServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GametraderPostServiceApplication.class, args);
    }

}
