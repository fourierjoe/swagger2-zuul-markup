package com.qiao;

import com.qiao.swagger2.EnableSwaggerKeeper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 聚合product/customer服務文檔
 *
 */
@EnableSwaggerKeeper
@EnableDiscoveryClient
@SpringBootApplication
public class StaticApplication {
    public static void main( String[] args ) {
        SpringApplication.run(StaticApplication.class);
        StringBuilder sb = new StringBuilder("====================Static Service Start Success======================");
        System.out.println(sb.toString());
    }
}
