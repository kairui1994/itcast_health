package com.xdsdjq.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xdsdjq.dao.OrderSettingDao;
import com.xdsdjq.pojo.OrderSetting;
import com.xdsdjq.service.OrderSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;

@Service(interfaceClass = OrderSettingService.class)
@Transactional
public class OrderSettingServiceImpl implements OrderSettingService {

    @Autowired
    private OrderSettingDao orderSettingDao;

    public void add(List<OrderSetting> list) {
        if (list != null && list.size() > 0) {
            for (OrderSetting orderSetting : list) {
                Integer count = orderSettingDao.findCountByOrderDate(orderSetting.getOrderDate());
                if (count > 0) {
                    //更新操作
                    orderSettingDao.updateNumberByOrderDate(orderSetting);
                } else {
                    orderSettingDao.add(orderSetting);
                }
            }
        }
    }

    public List<Map> findOrderSettingByMonth(String date) {
        List<Map> mapList = new ArrayList<>();
        List<OrderSetting> orderSettingList = orderSettingDao.findOrderSettingByMonth(date);
        if (orderSettingList != null && orderSettingList.size() > 0) {
            for (OrderSetting orderSetting : orderSettingList) {
                Map<String, Integer> map = new HashMap<>();

                //{ date: 1, number: 120, reservations: 1 },
                map.put("date", orderSetting.getOrderDate().getDate());
                map.put("number", orderSetting.getNumber());
                map.put("reservations", orderSetting.getReservations());
                mapList.add(map);
            }
        }
        return mapList;
    }

    //修改可预约人数
    public void editNumberByDate(OrderSetting orderSetting) {
        orderSettingDao.updateNumberByOrderDate(orderSetting);
    }
}
