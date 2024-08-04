package com.example.dto;

import com.example.pojo.Customer;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
public class OrderDetail {

    private Integer roomId;
    private Integer total;
    private LocalDateTime payTime;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private List<Customer> customers;
}
