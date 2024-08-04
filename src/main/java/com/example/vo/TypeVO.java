package com.example.vo;

import com.example.pojo.Room;
import com.example.pojo.RoomType;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class TypeVO {

    private RoomType roomType;
    private List<Room> rooms;
}
