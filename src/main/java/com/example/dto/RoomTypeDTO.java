package com.example.dto;

import com.example.pojo.Room;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class RoomTypeDTO {


    private String roomType;

    private Integer limitCount;

    private BigDecimal unitPrice;

    private List<Room> rooms;
}
