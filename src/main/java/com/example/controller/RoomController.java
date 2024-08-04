package com.example.controller;


import com.example.pojo.Customer;
import com.example.pojo.Room;
import com.example.result.Result;
import com.example.service.RoomService;
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
@RequestMapping("/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping("/show")
    public Result<List<Room>> show(){

        List<Room> roomList=roomService.list();
        return Result.success(roomList);
    }

    @GetMapping("/find/{id}")
    public Result<Room> find(@PathVariable("id") int id){

        Room room = roomService.getById(id);
        return Result.success(room);
    }

    @PutMapping("/upd")
    public Result updById(@RequestBody Room room){
        roomService.updateById(room);
        return Result.success();
    }
}

