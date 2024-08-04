package com.example.service;

import com.example.dto.AdminLoginDTO;
import com.example.pojo.Admin;

import javax.security.auth.login.AccountNotFoundException;

public interface AdminService {
    Admin login(AdminLoginDTO adminLoginDTO) throws AccountNotFoundException;
}

