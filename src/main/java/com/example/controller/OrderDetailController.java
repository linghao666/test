package com.example.controller;

import com.example.dto.OrderDetail;
import com.example.result.Result;
import com.example.service.OrderDetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@CrossOrigin
@Slf4j
public class OrderDetailController {

    @Autowired
    private OrderDetailService orderDetailService;


    @PostMapping("/ord")
    public Result order(@RequestBody OrderDetail orderDetail){
        //保存客户
        orderDetailService.order(orderDetail);
        return Result.success();
    }
}
