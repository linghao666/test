package com.example.controller;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.dto.RoomTypeDTO;
import com.example.dto.RoomTypeUpdDTO;
import com.example.mapper.RoomMapper;
import com.example.pojo.Room;
import com.example.pojo.RoomType;
import com.example.result.Result;
import com.example.service.RoomService;
import com.example.service.RoomTypeService;
import com.example.vo.TypeVO;
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
@RequestMapping("/roomType")
public class RoomTypeController {

    @Autowired
    private RoomTypeService roomTypeService;

    @Autowired
    private RoomService roomService;

    @Autowired
    private RoomMapper roomMapper;

    @GetMapping("/type/{id}")
    public Result<TypeVO> type(@PathVariable("id") int id){

        TypeVO typeVO=roomTypeService.type(id);
        return Result.success(typeVO);
    }

    @GetMapping("/show")
    public Result<List<RoomType>> show(){

        List<RoomType> roomTypeList = roomTypeService.list();
        return Result.success(roomTypeList);
    }

    @PostMapping("/add")
    public Result add(@RequestBody RoomTypeDTO roomTypeDTO){
        RoomType roomType=new RoomType();
        roomType.setRoomType(roomTypeDTO.getRoomType()).setUnitPrice(roomTypeDTO.getUnitPrice()).setLimitCount(roomTypeDTO.getLimitCount());
        roomTypeService.save(roomType);
        int id=roomType.getId();
        for(Room room:roomTypeDTO.getRooms()){
            room.setRoomTypeId(id);
            roomMapper.update(room, Wrappers.<Room>lambdaUpdate().eq(Room::getRoomNum,room.getRoomNum()));
        }
        return Result.success();
    }

    @PostMapping("/del")
    public Result del(@RequestBody RoomType roomType){

        roomTypeService.removeById(roomType);
        return Result.success();
    }

    @PostMapping("/upd")
    public Result upd(@RequestBody RoomType roomType){
//        RoomType roomType=new RoomType();
//        roomType.setRoomType(roomTypeUpdDTO.getRoomType()).setUnitPrice(roomTypeUpdDTO.getUnitPrice()).setLimitCount(roomTypeUpdDTO.getLimitCount()).setId(roomTypeUpdDTO.getId());
//        roomTypeService.updateById(roomType);
//        int id=roomTypeUpdDTO.getId();
//        for(Room room:roomTypeUpdDTO.getRooms()){
//            room.setRoomTypeId(id);
//            roomMapper.update(room, Wrappers.<Room>lambdaUpdate().eq(Room::getRoomNum,room.getRoomNum()));
//        }

        roomTypeService.updateById(roomType);
        return Result.success();
    }
}

