package com.xdsdjq.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xdsdjq.constant.MessageConstant;
import com.xdsdjq.dao.MemberDao;
import com.xdsdjq.dao.OrderDao;
import com.xdsdjq.dao.OrderSettingDao;
import com.xdsdjq.entity.Result;
import com.xdsdjq.pojo.Member;
import com.xdsdjq.pojo.Order;
import com.xdsdjq.pojo.OrderSetting;
import com.xdsdjq.service.OrderService;
import com.xdsdjq.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service(interfaceClass = OrderService.class)
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private MemberDao memberDao;

    @Autowired
    private OrderSettingDao orderSettingDao;

    //体检预约
    public Result order(Map map) throws Exception {
        //1.检验当前日期是否进行了预约设置
        String orderDate = (String) map.get("orderDate");
        Date date = DateUtils.parseString2Date(orderDate);
        OrderSetting orderSetting = orderSettingDao.findByOrderDate(date);
        if (orderSetting == null) {
            return new Result(false, MessageConstant.SELECTED_DATE_CANNOT_ORDER);
        }
        //2.检查当前日期是否已经预约满
        int number = orderSetting.getNumber();
        int reservations = orderSetting.getReservations();
        if (reservations == number) {
            return new Result(false, MessageConstant.ORDER_FULL);
        }
        //3.判断是不是会员
        String telephone = (String) map.get("telephone");
        Member member = memberDao.findByTelephone(telephone);

        if (member != null) {
            //3.1是会员，继续校验是否重复预约
            Integer memberId = member.getId();
            String setmealId = (String) map.get("setmealId");
            Order order = new Order(memberId, date, Integer.parseInt(setmealId));
            List<Order> list = orderDao.findByCondition(order);
            if (list != null && list.size() > 0) {
                //已经预约过，不可以重复预约
                return new Result(false, MessageConstant.HAS_ORDERED);
            }
        }

        if (member == null) {
            member = new Member();
            //3.2不是会员 自动注册成会员
            member.setName((String) map.get("name"));
            member.setPhoneNumber(telephone);
            member.setRegTime(new Date());
            member.setIdCard((String) map.get("idCard"));
            member.setSex((String) map.get("sex"));
            memberDao.add(member);
        }

        orderSetting.setReservations(orderSetting.getReservations() + 1);
        orderSettingDao.editReservationsByOrderDate(orderSetting);

        //4.保存预约信息到order表
        Order order = new Order(member.getId(), date, (String) map.get("orderType"),
                                Order.ORDERSTATUS_NO, Integer.parseInt((String) map.get("setmealId")));

        orderDao.add(order);
        return new Result(true,MessageConstant.ORDER_SUCCESS,order.getId());
    }

    @Override
    public Map findById(Integer id) {
        Map map = orderDao.findById4Detail(id);
        if(map != null){
            //处理日期格式
            Date orderDate = (Date) map.get("orderDate");
            try {
                map.put("orderDate",DateUtils.parseDate2String(orderDate));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return map;
    }
}
