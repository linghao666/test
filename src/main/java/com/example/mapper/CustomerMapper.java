package com.example.mapper;

import com.example.pojo.Customer;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lh
 * @since 2024-05-03
 */
@Mapper
public interface CustomerMapper extends BaseMapper<Customer> {

}
