package com.xdsdjq.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xdsdjq.dao.MemberDao;
import com.xdsdjq.dao.OrderDao;
import com.xdsdjq.service.ReportService;
import com.xdsdjq.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service(interfaceClass = ReportService.class)
@Transactional
public class ReportServiceImpl implements ReportService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private MemberDao memberDao;


    public Map<String, Object> getBusinessReport() throws Exception {

        //获得本周一的日期
        String thisWeekMonday = DateUtils.parseDate2String(DateUtils.getThisWeekMonday());
        //获得本月第一天的日期
        String firstDay4ThisMonth =
                DateUtils.parseDate2String(DateUtils.getFirstDay4ThisMonth());

        String today = DateUtils.parseDate2String(DateUtils.getToday());

        //今日新增会员数
        Integer todayNewMember = memberDao.findMemberCountByDate(today);

        //总会员数
        Integer totalMember = memberDao.findMemberTotalCount();

        //本周新增会员数
        Integer thisWeekNewMember = memberDao.findMemberCountAfterDate(thisWeekMonday);

        //本月新增会员数
        Integer thisMonthNewMember = memberDao.findMemberCountAfterDate(firstDay4ThisMonth);

        //今日预约人数
        Integer todayOrderNumber = orderDao.findOrderCountByDate(today);

        //本月预约数
        Integer thisMonthOrderNumber = orderDao.findOrderCountAfterDate(firstDay4ThisMonth);

        //今日就诊人数
        Integer todayVisitsNumber = orderDao.findVisitsCountByDate(today);

        //本周预约人数
        Integer thisWeekOrderNumber = orderDao.findOrderCountAfterDate(thisWeekMonday);

        //本周就诊人数
        Integer thisWeekVisitsNumber = orderDao.findVisitsOrderCountAfterDate(thisWeekMonday);

        //本月就诊人数
        Integer thisMonthVisitsNumber = orderDao.findVisitsOrderCountAfterDate(firstDay4ThisMonth);

        //热门套餐
        List<Map> hotSetmeal = orderDao.findHotSetMeal();
        Map<String, Object> map = new HashMap<>();
        map.put("reportDate", today);
        map.put("todayNewMember", todayNewMember);
        map.put("totalMember", totalMember);
        map.put("thisWeekNewMember", thisWeekNewMember);
        map.put("thisMonthNewMember", thisMonthNewMember);
        map.put("todayOrderNumber", todayOrderNumber);
        map.put("todayVisitsNumber", todayVisitsNumber);
        map.put("thisWeekOrderNumber", thisWeekOrderNumber);
        map.put("thisWeekVisitsNumber", thisWeekVisitsNumber);
        map.put("thisMonthVisitsNumber", thisMonthVisitsNumber);
        map.put("thisMonthOrderNumber",thisMonthOrderNumber);
        map.put("hotSetmeal", hotSetmeal);
        return map;
    }

}
