package com.example.controller;


import com.example.mapper.OrdersMapper;
import com.example.pojo.Orders;
import com.example.result.Result;
import com.example.service.OrdersService;
import com.example.vo.OrdersVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lh
 * @since 2024-05-03
 */
@RestController
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private OrdersMapper ordersMapper;

    @GetMapping("/show")
    public Result<List<OrdersVO>> show(){
        List<OrdersVO> ordersVOList =ordersService.show();
        return Result.success(ordersVOList);
    }

    @GetMapping("/turnover")
    public Result<List<Map<String, Object>>> turnover(){
        List<Map<String, Object>> totalTurnoverList = ordersMapper.getTotalTurnoverPerDay();
        totalTurnoverList.sort(Comparator.comparing(map -> (Date) map.get("day")));

        return Result.success(totalTurnoverList);
    }
}

