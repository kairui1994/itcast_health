package com.xdsdjq.dao;

import com.xdsdjq.pojo.OrderSetting;

import java.util.Date;
import java.util.List;


public interface OrderSettingDao {
    void add(OrderSetting data);

    Integer findCountByOrderDate(Date orderDate);

    void updateNumberByOrderDate(OrderSetting orderSetting);

    List<OrderSetting> findOrderSettingByMonth(String date);

    OrderSetting findByOrderDate(Date date);

    void editReservationsByOrderDate(OrderSetting orderSetting);
}
