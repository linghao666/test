package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.dto.OrdersDTO;
import com.example.pojo.Orders;
import com.example.result.Result;
import com.example.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrdersDTOController {

    @Autowired
    private OrdersService ordersService;
    @PostMapping ("/orderInfo")
    public Result<Orders> orderInfo(@RequestBody OrdersDTO ordersDTO){

        QueryWrapper<Orders> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("room_id", ordersDTO.getRoomId())
                .le("start_time", ordersDTO.getTime())
                .ge("end_time", ordersDTO.getTime());
        Orders orders=ordersService.getOne(queryWrapper);
        return Result.success(orders);
    }
}
