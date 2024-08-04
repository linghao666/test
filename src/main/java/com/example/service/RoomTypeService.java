package com.example.service;

import com.example.pojo.RoomType;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.vo.TypeVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lh
 * @since 2024-05-03
 */
public interface RoomTypeService extends IService<RoomType> {

    TypeVO type(int id);
}
