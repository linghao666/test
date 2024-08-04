package com.example.service;

import com.example.pojo.Customer;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.vo.CustomerVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lh
 * @since 2024-05-03
 */
public interface CustomerService extends IService<Customer> {

    List<CustomerVO> show();
}
