package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mapper.RoomMapper;
import com.example.pojo.Room;
import com.example.pojo.RoomType;
import com.example.mapper.RoomTypeMapper;
import com.example.service.RoomTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.vo.TypeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lh
 * @since 2024-05-03
 */
@Service
public class RoomTypeServiceImpl extends ServiceImpl<RoomTypeMapper, RoomType> implements RoomTypeService {

    @Autowired
    private RoomTypeService roomTypeService;
    @Autowired
    private RoomMapper roomMapper;
    @Override
    public TypeVO type(int id) {

        RoomType roomType=roomTypeService.getById(id);
        QueryWrapper<Room> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("room_type_id", id);
        List<Room> roomList = roomMapper.selectList(queryWrapper);
        TypeVO typeVO= TypeVO.builder().roomType(roomType).rooms(roomList).build();
        return typeVO;
    }
}
