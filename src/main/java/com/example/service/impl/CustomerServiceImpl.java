package com.example.service.impl;

import com.example.pojo.Customer;
import com.example.mapper.CustomerMapper;
import com.example.pojo.CustomerInRoom;
import com.example.pojo.Room;
import com.example.service.CustomerInRoomService;
import com.example.service.CustomerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.service.RoomService;
import com.example.vo.CustomerVO;
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
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements CustomerService {


    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerInRoomService customerInRoomService;
    @Autowired
    private RoomService roomService;
    @Override
    public List<CustomerVO> show() {

        List<CustomerInRoom> customerInRoomList=customerInRoomService.list();
        List<CustomerVO> customerVOList=new ArrayList<>();
        for(CustomerInRoom customerInRoom:customerInRoomList){
            CustomerVO customerVO=new CustomerVO();
            Customer customer= new Customer();
            Room room=new Room();
            customer=customerService.getById(customerInRoom.getCustomerId());
            room=roomService.getById(customerInRoom.getRoomId());
            customerVO=CustomerVO.builder().customer(customer).roomNum(room.getRoomNum()).startTime(customerInRoom.getStartTime()).endTime(customerInRoom.getEndTime()).build();
            customerVOList.add(customerVO);
        }
        return customerVOList;
    }
}
