package com.example;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.dto.RoomTypeDTO;
import com.example.mapper.OrdersMapper;
import com.example.mapper.RoomMapper;
import com.example.pojo.Customer;
import com.example.pojo.Orders;
import com.example.pojo.Room;
import com.example.pojo.RoomType;
import com.example.service.CustomerService;
import com.example.service.OrdersService;
import com.example.service.RoomTypeService;
import com.example.utils.DateUtil;
import com.google.gson.Gson;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    private RoomMapper roomMapper;
    @Autowired
    private RoomTypeService roomTypeService;

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private OrdersMapper ordersMapper;
    @Test
    void contextLoads(){
        List<Map<String, Object>> totalTurnoverList = ordersMapper.getTotalTurnoverPerDay();
        for (Map<String, Object> entry : totalTurnoverList) {
            System.out.println("Day: " + entry.get("day") + ", Total Turnover: " + entry.get("total_turnover"));
        }

    }

    @Test
    void test(){
            int[][] map = new int[500][14];
            // 获取当前日期和时间
            LocalDateTime currentDateTime = LocalDateTime.now();
            // 截断时间戳到日
            LocalDateTime truncatedDateTime = currentDateTime.truncatedTo(java.time.temporal.ChronoUnit.DAYS);
            List<Orders> ordersList=ordersService.list();
            for(Orders orders:ordersList){
                LocalDateTime localDateTime1=orders.getStartTime();
                LocalDateTime localDateTime2=orders.getEndTime();

                long start= DateUtil.getDaysDifference(truncatedDateTime,localDateTime1);
                long end =DateUtil.getDaysDifference(truncatedDateTime,localDateTime2);

                System.out.println(start);
                System.out.println(end);
                for(int j=0;j<14;j++){
                    if(j>=start&&j<=end){
                        if(start<=0&&end>=0){
                            map[orders.getRoomId()][j] = 2;
                            continue;
                        }
                        map[orders.getRoomId()][j] = 1;
                    }
                }
            }
            for(int i=1;i<500;i++) {
                for (int j = 0; j < 14; j++) {
                    System.out.print(map[i][j]);
                }
                System.out.println("");
            }
    }
}
