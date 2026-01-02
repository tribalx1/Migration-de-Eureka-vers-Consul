package com.olaya.layadi.servereureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Serveur Eureka - TP Consul
 * Auteur : Olaya Layadi
 */
@SpringBootApplication
@EnableEurekaServer
public class ServerEurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServerEurekaApplication.class, args);
    }
}
