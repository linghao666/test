package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mapper.OrdersMapper;
import com.example.pojo.Orders;
import com.example.pojo.Room;
import com.example.service.OrdersService;
import com.example.service.RoomService;
import com.example.service.ScheduleService;
import com.example.utils.DateUtil;
import com.example.vo.RoomStatusVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private RoomService roomService;

    @Autowired
    private OrdersMapper ordersMapper;

    @Override
    public List<RoomStatusVO> schedule(){
        List<RoomStatusVO> roomStatusVOList = new ArrayList<>();
        // 获取当前日期和时间
        LocalDateTime currentDateTime = LocalDateTime.now();
        // 截断时间戳到日
        LocalDateTime truncatedDateTime = currentDateTime.truncatedTo(java.time.temporal.ChronoUnit.DAYS);
//        List<Orders> ordersList=ordersService.list();
        List<Room> roomList =roomService.list();
        for(Room room:roomList){

            RoomStatusVO roomStatusVO=new RoomStatusVO();
            int[] status =new int[14];
            //通过roomid查找
            QueryWrapper<Orders> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("room_id", room.getId());
            List<Orders> ordersList=ordersMapper.selectList(queryWrapper);
            for(Orders orders:ordersList) {

                LocalDateTime localDateTime1 = orders.getStartTime();
                LocalDateTime localDateTime2 = orders.getEndTime();

                long start = DateUtil.getDaysDifference(truncatedDateTime, localDateTime1);
                long end = DateUtil.getDaysDifference(truncatedDateTime, localDateTime2);

                for (int j = 0; j < 14; j++) {
                    if (j >= start && j <= end) {
                        if (start <= 0 && end >= 0) {
                            status[j] = 2;
                            continue;
                        }
                        status[j] = 1;
                    }
                }
            }
            roomStatusVO.setRoom(room);
            roomStatusVO.setStatus(status);
            roomStatusVOList.add(roomStatusVO);

        }

















//        for(Orders orders:ordersList){
//            RoomStatusVO roomStatusVO=new RoomStatusVO();
//            int[] status =new int[14];
//            LocalDateTime localDateTime1=orders.getStartTime();
//            LocalDateTime localDateTime2=orders.getEndTime();
//
//            long start= DateUtil.getDaysDifference(truncatedDateTime,localDateTime1);
//            long end =DateUtil.getDaysDifference(truncatedDateTime,localDateTime2);
//
//            for(int j=0;j<14;j++){
//                if(j>=start&&j<=end){
//                    if(start<=0&&end>=0){
//                        status[j] = 2;
//                        continue;
//                    }
//                    status[j] = 1;
//                }
//            }
//            Room room=roomService.getById(orders.getRoomId());
//            roomStatusVO.setRoom(room);
//            roomStatusVO.setStatus(status);
//            roomStatusVOList.add(roomStatusVO);
//        }
        Collections.sort(roomStatusVOList, new Comparator<RoomStatusVO>() {
            @Override
            public int compare(RoomStatusVO o1, RoomStatusVO o2) {
                return o1.getRoom().getRoomTypeId().compareTo(o2.getRoom().getRoomTypeId());
            }
        });
        return roomStatusVOList;
    }
}
