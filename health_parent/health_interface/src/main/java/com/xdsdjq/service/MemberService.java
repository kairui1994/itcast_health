package com.xdsdjq.service;

import com.xdsdjq.entity.PageResult;
import com.xdsdjq.entity.QueryPageBean;
import com.xdsdjq.pojo.Member;

import java.util.List;
import java.util.Map;

public interface MemberService {

    Member findByTelephone(String telephone);

    int add(Member member);

    List<Integer> findMemberCountByMonths(List<String> months);

    PageResult pageQuery(QueryPageBean queryPageBean);

    Member findById(Integer id);

    void changeStatus(Map map);
}
