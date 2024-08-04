package com.example.mapper;

import com.example.pojo.Room;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.lettuce.core.dynamic.annotation.Param;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lh
 * @since 2024-05-03
 */
@Mapper
public interface RoomMapper extends BaseMapper<Room> {

//    @Update("UPDATE room SET room_type_id = #{roomTypeId} WHERE room_num = #{roomNum}")
//    int updateRoomByNum(@Param("roomNum") int roomNum, @Param("roomTypeId") int roomTypeId);

}
