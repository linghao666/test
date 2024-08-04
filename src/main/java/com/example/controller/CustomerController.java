package com.example.controller;


import com.example.pojo.Customer;
import com.example.result.Result;
import com.example.service.CustomerService;
import com.example.vo.CustomerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/show")
    public Result<List<CustomerVO>> show(){

        List<CustomerVO> customerVOList=customerService.show();
        return Result.success(customerVOList);
    }

    @GetMapping("/find/{id}")
    public Result<Customer> find(@PathVariable("id") int id){

        Customer customer =customerService.getById(id);
        return Result.success(customer);
    }

    @PutMapping("/upd")
    public Result updById(@RequestBody Customer customer){
         customerService.updateById(customer);
         return Result.success();
    }
}

