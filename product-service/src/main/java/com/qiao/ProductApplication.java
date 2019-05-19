package com.qiao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Hello world!
 *
 */
@EnableDiscoveryClient
@EnableSwagger2
@SpringBootApplication
public class ProductApplication {
    public static void main( String[] args ) {
        SpringApplication.run(ProductApplication.class);
        StringBuilder sb = new StringBuilder("====================Product Service Start Success======================");
        System.out.println(sb.toString());
    }
}
