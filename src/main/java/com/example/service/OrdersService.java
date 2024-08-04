package com.example.service;

import com.example.pojo.Orders;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.vo.OrdersVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lh
 * @since 2024-05-03
 */
public interface OrdersService extends IService<Orders> {

    List<OrdersVO> show();
}
