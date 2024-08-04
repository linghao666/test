package com.example.controller;

import com.example.result.Result;
import com.example.service.ScheduleService;
import com.example.vo.RoomStatusVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @GetMapping("/schedule")
    public Result<List<RoomStatusVO>> schedule(){

        List<RoomStatusVO> roomStatusVOList=scheduleService.schedule();
        return Result.success(roomStatusVOList);
    }
}
