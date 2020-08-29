package com.xdsdjq.dao;

import com.github.pagehelper.Page;
import com.xdsdjq.entity.QueryPageBean;
import com.xdsdjq.pojo.OrderSetting;

import java.util.Date;
import java.util.List;
import java.util.Map;


public interface OrderSettingDao {
    void add(OrderSetting data);

    Integer findCountByOrderDate(Date orderDate);

    void updateNumberByOrderDate(OrderSetting orderSetting);

    List<OrderSetting> findOrderSettingByMonth(String date);

    OrderSetting findByOrderDate(Date date);

    void editReservationsByOrderDate(OrderSetting orderSetting);

    Page<Map<String, Object>> findPage(Map<String, Object> map);

    void deleteOrderById(Integer id);
}
