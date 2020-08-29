package com.xdsdjq.dao;

import com.github.pagehelper.Page;
import com.xdsdjq.pojo.Member;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MemberDao {
    Member findByTelephone(String telephone);

    public List<Member> findAll();

    public List<Member> selectByCondition(@Param("queryString") String queryString);

    public void add(Member member);

    public void deleteById(Integer id);

    public Member findById(Integer id);

    public void edit(Member member);

    public Integer findMemberCountBeforeDate(String date);

    public Integer findMemberCountByDate(String date);

    public Integer findMemberCountAfterDate(String date);

    public Integer findMemberTotalCount();
}
