package com.example.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrdersVO {

    private Integer id;
    private Integer roomNum;
    private String customerName;
    private Integer total;
    private LocalDateTime payTime;

    private LocalDateTime startTime;

    private LocalDateTime endTime;
}
