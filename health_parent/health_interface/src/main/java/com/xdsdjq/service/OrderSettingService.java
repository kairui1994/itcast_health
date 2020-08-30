package com.xdsdjq.service;

import com.xdsdjq.entity.PageResult;
import com.xdsdjq.entity.QueryPageBean;
import com.xdsdjq.pojo.Order;
import com.xdsdjq.pojo.OrderSetting;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface OrderSettingService {
    void add(List<OrderSetting> data);

    List<Map> findOrderSettingByMonth(String date);

    void editNumberByDate(OrderSetting orderSetting);

    Map findOrdersPage(QueryPageBean queryPageBean) throws Exception;

    void submit(Integer[] setmealIds, Map<String, Object> map) throws Exception;

    void deleteOrderById(Integer id);

    OrderSetting findByOrderDate(Date date);

    void editReservationsByOrderDate(OrderSetting orderSetting);

    void deleteAll(Integer[] orderIds);

    String findByStatus(Integer id);
}
