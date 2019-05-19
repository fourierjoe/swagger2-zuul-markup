package com.qiao.swagger2;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Description:
 * @Created by ql on 2019/5/18/018 15:46
 * @Version: v1.0
 */
@Configuration
@EnableSwagger2
@EnableConfigurationProperties(SwaggerKeeperProperties.class)
public class SwaggerKeeperAutoConfig {

    @Bean
    @Primary
    public SwaggerResourcesProcessor swaggerResourcesProcessor() {
        return new SwaggerResourcesProcessor();
    }
}
