package com.example.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.pojo.Orders;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.pojo.Room;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lh
 * @since 2024-05-03
 */
@Mapper
public interface OrdersMapper extends BaseMapper<Orders> {
    @Select("SELECT DATE(pay_time) AS day, SUM(total) AS total_turnover FROM orders GROUP BY day")
    List<Map<String, Object>> getTotalTurnoverPerDay();
}

