package com.qiao.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Created by ql on 2019/5/18/018 13:09
 * @Version: v1.0
 */
@RequestMapping("/product")
@RestController
@Api(value = "ProductController", tags = "商品服務")
public class ProductController {

    @ApiResponses(
            @ApiResponse(code = 200, message = "成功")
    )
    @GetMapping("/")
    public String productTest() {
        return "test product";
    }
}
