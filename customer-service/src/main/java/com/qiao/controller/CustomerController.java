package com.qiao.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Created by ql on 2019/5/18/018 13:06
 * @Version: v1.0
 */
@RequestMapping("/customer")
@RestController
@Api(value = "CustomerController", tags = "客戶服務")
public class CustomerController {

    @ApiResponses(
            @ApiResponse(code = 200, message = "成功")
    )
    @GetMapping("/")
    public String customerTest() {
        return "test customer";
    }
}
