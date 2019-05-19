package com.qiao.swagger2;

import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @Description:
 * @Created by ql on 2019/5/18/018 16:11
 * @Version: v1.0
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(SwaggerKeeperAutoConfig.class)
@EnableZuulProxy
public @interface EnableSwaggerKeeper {
}
