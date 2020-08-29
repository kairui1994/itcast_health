package com.xdsdjq.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xdsdjq.entity.Result;
import com.xdsdjq.service.OrderService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/localOrder")
public class ShortMessageController {
    @Reference
    private OrderService orderService;

    @RequestMapping("/notification")
    public Result notification(String phoneNumber, Date orderDate){
        System.out.println("预约成功");
        return null;
    }

}
