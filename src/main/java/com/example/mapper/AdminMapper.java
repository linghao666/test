package com.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import com.example.pojo.Admin;

@Mapper
public interface AdminMapper {
    /**
     * 根据用户名查询员工
     * @param account
     * @return
     */
    @Select("select * from user where account = #{account}")
    Admin getByAccount(String account);
}
