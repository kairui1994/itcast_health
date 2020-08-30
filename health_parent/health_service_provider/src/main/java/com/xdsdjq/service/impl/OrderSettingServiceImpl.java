package com.xdsdjq.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xdsdjq.dao.OrderDao;
import com.xdsdjq.dao.OrderSettingDao;
import com.xdsdjq.entity.QueryPageBean;
import com.xdsdjq.pojo.Order;
import com.xdsdjq.pojo.OrderSetting;
import com.xdsdjq.service.OrderSettingService;
import com.xdsdjq.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import static com.xdsdjq.pojo.Order.ORDERTYPE_TELEPHONE;

@Service(interfaceClass = OrderSettingService.class)
@Transactional
public class OrderSettingServiceImpl implements OrderSettingService {

    @Autowired
    private OrderSettingDao orderSettingDao;
    @Autowired
    private OrderDao orderDao;

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

    @Override
    public Map findOrdersPage(QueryPageBean queryPageBean) throws Exception {
        //获取数据
        Integer currentPage = queryPageBean.getCurrentPage();
        Integer pageSize = queryPageBean.getPageSize();
        String queryString = queryPageBean.getQueryString();
        //开启分页查询
        PageHelper.startPage(currentPage, pageSize);
        //json对象转map
        Map<String, Object> map = JSON.parseObject(queryString);

        //提取开始结束日期
        String startDate = (String) map.get("startDate");
        String endDate = (String) map.get("endDate");

        //声明开始结束的日期
        Date startDate_2 = null;
        Date endDate_2 = null;

        //判断日期是否为空
        if (startDate != null && startDate.length() > 0 && endDate != null && endDate.length() > 0) {
            startDate_2 = DateUtils.parseString2Date(startDate);
            endDate_2 = DateUtils.parseString2Date(endDate);
        }

        //添加到map集合中
        map.put("startDate", startDate_2);
        map.put("endDate", endDate_2);
        //调用数据层查询预约信息
        Page<Map<String, Object>> pageMap = orderSettingDao.findPage(map);
        //System.out.println(pageMap);
        //转成list集合
        List<Map<String, Object>> dbMap = pageMap.getResult();

        for (Map<String, Object> stringObjectMap : dbMap) {
            Date orderDate = (Date) stringObjectMap.get("orderDate");
            String date2String = DateUtils.parseDate2String(orderDate);
            stringObjectMap.replace("orderDate", date2String);
        }

        //新建map封装前台需要的数据
        Map resoutmap = new HashMap();
        resoutmap.put("total", pageMap.getTotal());//pageMap.getTotal()获取总条数
        resoutmap.put("rows", dbMap);
        return resoutmap;
    }

    @Override
    public void submit(Integer[] setmealIds, Map<String, Object> map) throws Exception {
        System.out.println(map + "===============================================");
        String orderDate = (String) map.get("orderDate");
        Date date = DateUtils.parseString2Date(orderDate);
        //给order表赋值
        Order order = new Order();
        order.setOrderDate(date);
        order.setMemberId((Integer) map.get("member_id"));
        order.setOrderStatus("未到诊");
        order.setOrderType(ORDERTYPE_TELEPHONE);
        for (Integer setmealId : setmealIds) {
            order.setSetmealId(setmealId);
            orderDao.add(order);
        }
    }

    @Override
    public void deleteOrderById(Integer id) {
        orderSettingDao.deleteOrderById(id);
    }

    @Override
    public OrderSetting findByOrderDate(Date date) {
        return orderSettingDao.findByOrderDate(date);
    }

    @Override
    public void editReservationsByOrderDate(OrderSetting orderSetting) {
        orderSettingDao.editReservationsByOrderDate(orderSetting);
    }

    @Override
    public void deleteAll(Integer[] orderIds) {
        for (Integer orderId : orderIds) {
            String byStatus = orderDao.findByStatus(orderId);
            if (byStatus.equals(Order.ORDERSTATUS_NO)) {
                orderDao.deleteAll(orderId);
            }
        }
    }

    @Override
    public String findByStatus(Integer id) {
        return orderDao.findByStatus(id);
    }
}
