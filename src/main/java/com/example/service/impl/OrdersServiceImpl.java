package com.example.service.impl;

import com.example.pojo.Customer;
import com.example.pojo.Orders;
import com.example.mapper.OrdersMapper;
import com.example.pojo.Room;
import com.example.service.CustomerService;
import com.example.service.OrdersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.service.RoomService;
import com.example.vo.OrdersVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lh
 * @since 2024-05-03
 */
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements OrdersService {

    @Autowired
    private OrdersService ordersService;
    @Autowired
    private RoomService roomService;
    @Autowired
    private CustomerService customerService;
    @Override
    public List<OrdersVO> show() {

        List<OrdersVO> ordersVOList=new ArrayList<>();
        List<Orders> ordersList =ordersService.list();
        for(Orders orders:ordersList){
            OrdersVO ordersVO=new OrdersVO();
            Room room =roomService.getById(orders.getRoomId());
            Customer customer=customerService.getById(orders.getCustomerId());
            ordersVO=OrdersVO.builder().id(orders.getId()).roomNum(room.getRoomNum()).customerName(customer.getName()).total(orders.getTotal()).startTime(orders.getStartTime()).endTime(orders.getEndTime()).payTime(orders.getPayTime()).build();
            ordersVOList.add(ordersVO);
        }
        return ordersVOList;
    }
}
