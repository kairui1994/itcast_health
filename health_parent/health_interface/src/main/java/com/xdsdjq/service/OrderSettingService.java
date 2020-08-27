package com.xdsdjq.service;

import com.xdsdjq.pojo.OrderSetting;

import java.util.List;
import java.util.Map;

public interface OrderSettingService {
    void add(List<OrderSetting> data);

    List<Map> findOrderSettingByMonth(String date);

    void editNumberByDate(OrderSetting orderSetting);
}
