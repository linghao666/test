package com.example.controller;

import com.example.context.BaseContext;
import com.example.dto.AdminLoginDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.pojo.Admin;
import com.example.properties.JwtProperties;
import com.example.result.Result;
import com.example.service.AdminService;
import com.example.utils.JwtUtil;
import com.example.vo.AdminLoginVO;

import javax.security.auth.login.AccountNotFoundException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/admin")
@CrossOrigin
@Slf4j
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private JwtProperties jwtProperties;

    @PostMapping("/login")
    public Result<AdminLoginVO> login(@RequestBody AdminLoginDTO adminLoginDTO) throws AccountNotFoundException {
        log.info("员工登录：{}", adminLoginDTO);

        Admin admin = adminService.login(adminLoginDTO);

        //登录成功后，生成jwt令牌
        Map<String, Object> claims = new HashMap<>();
        claims.put("adminID", admin.getId());
        String token = JwtUtil.createJWT(
                jwtProperties.getAdminSecretKey(),
                jwtProperties.getAdminTtl(),
                claims);
        BaseContext.setCurrentId(admin.getId());
        AdminLoginVO adminLoginVO = AdminLoginVO.builder()
                .id(admin.getId())
                .account(admin.getAccount())
                .token(token)
                .build();

        return Result.success(adminLoginVO);
    }

    /**
     * 退出
     *
     * @return
     */
    @PostMapping("/logout")
    public Result<String> logout() {
        return Result.success();
    }
}
