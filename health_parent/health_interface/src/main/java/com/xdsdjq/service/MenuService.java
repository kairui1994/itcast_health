package com.xdsdjq.service;

import com.xdsdjq.entity.PageResult;
import com.xdsdjq.entity.QueryPageBean;
import com.xdsdjq.pojo.Menu;

import java.util.List;

public interface MenuService {
    Menu findMenuById(Integer id);

    PageResult pageQuery(QueryPageBean queryPageBean);

    List<Menu> findAll();

    void add(Menu menu, Integer[] roleIds);

    List<Integer> findRoleIdsByMenuId(Integer menuId);
}
