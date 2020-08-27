package com.xdsdjq.dao;

import com.xdsdjq.pojo.Order;

import java.util.List;
import java.util.Map;

public interface OrderDao {

    List<Order> findByCondition(Order order);

    void add(Order order);

    Map findById4Detail(Integer id);

    Integer findOrderCountByDate(String date);

    Integer findVisitsCountByDate(String date);

    Integer findOrderCountAfterDate(String date);

    Integer findVisitsOrderCountAfterDate(String date);

    List<Map> findHotSetMeal();
}
