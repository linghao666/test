package com.example.vo;

import com.example.pojo.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerVO {

    private Customer customer;
    private Integer roomNum;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
