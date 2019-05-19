package com.qiao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Hello world!
 *
 */
@EnableDiscoveryClient
@SpringBootApplication
public class CustomerApplication {
    public static void main( String[] args ) {
        SpringApplication.run(CustomerApplication.class);
        StringBuilder sb = new StringBuilder("====================Customer Service Start Success======================");
        System.out.println(sb.toString());
    }
}
