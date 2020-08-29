package com.xdsdjq.service;

import com.xdsdjq.entity.PageResult;
import com.xdsdjq.entity.QueryPageBean;
import com.xdsdjq.pojo.User;

import java.util.List;

public interface UserService {
    User findByUsername(String username);

    List<Object> getPathByUsername(String username);

    PageResult pageQuery(QueryPageBean queryPageBean);

    void add(User user,int[] roleIds);

    User findById(Integer id);

    void edit(User user);

    void deleteById(Integer userId);
}
