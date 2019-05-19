package com.qiao;

import com.qiao.swagger2.EnableSwaggerKeeper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 測試是否是通過zuul網關獲取路由信息的
 *
 */
@EnableDiscoveryClient
@EnableSwaggerKeeper
@SpringBootApplication
public class TestApplication {
    public static void main( String[] args ) {
        SpringApplication.run(TestApplication.class);
        StringBuilder sb = new StringBuilder("====================Test Service Start Success======================");
        System.out.println(sb.toString());
    }
}
