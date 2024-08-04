package com.example.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.dto.ChangeDTO;
import com.example.mapper.OrderChangeMapper;
import com.example.mapper.OrdersMapper;
import com.example.pojo.CustomerInRoom;
import com.example.pojo.OrderChange;
import com.example.pojo.Orders;
import com.example.result.Result;
import com.example.service.CustomerInRoomService;
import com.example.service.OrderChangeService;
import com.example.service.OrdersService;
import com.example.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lh
 * @since 2024-05-04
 */
@RestController
@RequestMapping("/orderChange")
public class OrderChangeController {


    @Autowired
    private OrdersService ordersService;
    @Autowired
    private OrderChangeService orderChangeService;

    @Autowired
    private CustomerInRoomService customerInRoomService;

    @PostMapping("/change")
    public Result change(@RequestBody ChangeDTO changeDTO){

        Orders orders=ordersService.getById(changeDTO.getId());
        QueryWrapper<CustomerInRoom> queryWrapper=new QueryWrapper<>();
        LocalDateTime time= DateUtil.truncateToDay(LocalDateTime.now());
        queryWrapper.eq("room_id", orders.getRoomId())
                .eq("start_time", orders.getStartTime())
                .eq("end_time", orders.getEndTime());
        List<CustomerInRoom> customerInRoomList=customerInRoomService.list(queryWrapper);
        for(CustomerInRoom customerInRoom:customerInRoomList){
            customerInRoom.setEndTime(time);
            customerInRoomService.updateById(customerInRoom);
        }

        OrderChange orderChange =new OrderChange();
        orderChange=OrderChange.builder().oldStartTime(orders.getStartTime()).oldEndTime(orders.getEndTime()).oldTotal(orders.getTotal()).changeOrderId(orders.getId()).build();
        orders.setEndTime(changeDTO.getEndTime());
        orders.setTotal(changeDTO.getTotal());
        ordersService.updateById(orders);
        orderChangeService.save(orderChange);

        return Result.success();
    }
}

