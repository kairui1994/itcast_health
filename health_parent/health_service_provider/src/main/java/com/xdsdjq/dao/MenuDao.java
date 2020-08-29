package com.xdsdjq.dao;

import com.xdsdjq.pojo.CheckItem;
import com.xdsdjq.pojo.Menu;

import java.util.List;

public interface MenuDao {
    Menu findMenuById(Integer id);

    List<Menu> selectByCondition(String queryString);

    List<Menu> findAll();
}
