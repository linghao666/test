package com.example.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.dto.OrdersDTO;
import com.example.mapper.CustomerMapper;
import com.example.pojo.Customer;
import com.example.pojo.CustomerInRoom;
import com.example.pojo.Orders;
import com.example.pojo.Room;
import com.example.result.Result;
import com.example.service.CustomerInRoomService;
import com.example.service.OrdersService;
import com.example.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lh
 * @since 2024-05-03
 */
@RestController
@RequestMapping("/customerInRoom")
public class CustomerInRoomController {

    @Autowired
    private CustomerInRoomService customerInRoomService;

    @Autowired
    private CustomerMapper customerMapper;

    @PostMapping("/customerinroom")
    public Result<List<Customer>> getById(@RequestBody OrdersDTO ordersDTO){

        QueryWrapper<CustomerInRoom> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("room_id", ordersDTO.getRoomId());

        List<CustomerInRoom> customerInRoomList=customerInRoomService.list(queryWrapper);
        List<Customer> customerList=new ArrayList<>();

        for(CustomerInRoom customerInRoom:customerInRoomList){

            int comparisonResult1 = customerInRoom.getStartTime().compareTo(ordersDTO.getTime());
            int comparisonResult2 = customerInRoom.getEndTime().compareTo(ordersDTO.getTime());
            if(comparisonResult1<=0&&comparisonResult2>=0){

                Customer customer=customerMapper.selectById(customerInRoom.getCustomerId());
                customerList.add(customer);
            }
        }
        return Result.success(customerList);
    }

}

