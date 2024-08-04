package com.example.service.impl;

import com.example.dto.AdminLoginDTO;
import com.example.exception.PasswordErrorException;
import com.example.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import com.example.pojo.Admin;
import com.example.service.AdminService;

import javax.security.auth.login.AccountNotFoundException;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;
    @Override
    public Admin login(AdminLoginDTO adminLoginDTO) throws AccountNotFoundException {
        String account = adminLoginDTO.getAccount();
        String password = adminLoginDTO.getPassword();

        //1、根据用户名查询数据库中的数据
        Admin admin=adminMapper.getByAccount(account);

        //2、处理各种异常情况（用户名不存在、密码不对、账号被锁定）
        if (admin == null) {
            //账号不存在
            throw  new AccountNotFoundException("账号不存在");
        }

        //密码比对
        //对前端传过来的明文密码进行md5加密处理
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        if (!password.equals(admin.getPassword())){
            //密码错误
            throw new PasswordErrorException("密码错误");
        }

        //3、返回实体对象
        return admin;
    }
}
