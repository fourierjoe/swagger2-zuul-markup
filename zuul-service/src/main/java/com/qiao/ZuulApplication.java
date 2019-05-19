package com.qiao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Hello world!
 *
 */
@EnableZuulProxy
@SpringBootApplication
public class ZuulApplication {
    public static void main( String[] args ) {
        SpringApplication.run(ZuulApplication.class);
        StringBuilder sb = new StringBuilder("====================Zuul Service Start Success======================");
        System.out.println(sb.toString());
    }
}
