package com.xdsdjq.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xdsdjq.dao.MemberDao;
import com.xdsdjq.dao.OrderDao;
import com.xdsdjq.entity.PageResult;
import com.xdsdjq.entity.QueryPageBean;
import com.xdsdjq.pojo.Member;
import com.xdsdjq.pojo.Order;
import com.xdsdjq.service.MemberService;
import com.xdsdjq.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service(interfaceClass = MemberService.class)
@Transactional
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberDao memberDao;
    @Autowired
    private OrderDao orderDao;

    public Member findByTelephone(String telephone) {
        return memberDao.findByTelephone(telephone);
    }

    //添加一个会员
    public int add(Member member) {
        String password = member.getPassword();
        member.setRegTime(new Date());
        if (password != null) {
            member.setPassword(MD5Utils.md5(password));
        }
        memberDao.add(member);
        Integer id = member.getId();
        return id;
    }

    @Override
    public List<Integer> findMemberCountByMonths(List<String> months) {

        List<Integer> memberCount = new ArrayList<>();
        for (String month : months) {
            Integer countBeforeDate = memberDao.findMemberCountBeforeDate(month + ".31");
            memberCount.add(countBeforeDate);
        }
        return memberCount;
    }

    @Override
    public PageResult pageQuery(QueryPageBean queryPageBean) {
        Integer currentPage = queryPageBean.getCurrentPage();
        Integer pageSize = queryPageBean.getPageSize();

        String queryString = queryPageBean.getQueryString();
        //完成分页查询，mybatis分页助手
        PageHelper.startPage(currentPage, pageSize);

        List<Member> memberList = memberDao.selectByCondition(queryString);
        PageInfo page = new PageInfo(memberList);
        long total = page.getTotal();
        List data = page.getList();
        return new PageResult(total, data);
    }

    @Override
    public Member findById(Integer id) {
        return memberDao.findById(id);
    }

    //修改预约状态
    public void changeStatus(Map map) {
        String status = (String) map.get("status");//状态
        Integer orderId = (Integer) map.get("orderId");//预约表id
        Order order = orderDao.findById(orderId);
        order.setOrderStatus(status);
        orderDao.changeStatus(order);
    }
}
