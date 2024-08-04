package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.context.BaseContext;
import com.example.dto.OrderDetail;
import com.example.mapper.OrderDetailMapper;
import com.example.pojo.Customer;
import com.example.pojo.CustomerInRoom;
import com.example.pojo.Orders;
import com.example.service.CustomerInRoomService;
import com.example.service.CustomerService;
import com.example.service.OrderDetailService;
import com.example.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail> implements OrderDetailService {


    @Autowired
    private OrdersService ordersService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerInRoomService customerInRoomService;

    @Override
    public void order(OrderDetail orderDetail) {

        //保存客户
        Customer customer1=orderDetail.getCustomers().get(0);
        customerService.save(customer1);
        CustomerInRoom customerInRoom1 =  CustomerInRoom.builder().roomId(orderDetail.getRoomId()).customerId(customer1.getId()).startTime(orderDetail.getStartTime()).endTime(orderDetail.getEndTime()).build();
        customerInRoomService.save(customerInRoom1);
        if(orderDetail.getCustomers().size()>1){
            Customer customer2=orderDetail.getCustomers().get(1);
            customerService.save(customer2);
            CustomerInRoom customerInRoom2 =  CustomerInRoom.builder().roomId(orderDetail.getRoomId()).customerId(customer2.getId()).startTime(orderDetail.getStartTime()).endTime(orderDetail.getEndTime()).build();
            customerInRoomService.save(customerInRoom2);
        }
        //保存客户住房

        //保存订单
        Orders orders = Orders.builder().roomId(orderDetail.getRoomId()).customerId(customer1.getId()).total(orderDetail.getTotal()).payTime(LocalDateTime.now()).startTime(orderDetail.getStartTime()).endTime(orderDetail.getEndTime()).userId(1).build();
        ordersService.save(orders);
    }
}
