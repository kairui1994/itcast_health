package com.xdsdjq.service;

import com.xdsdjq.pojo.Menu;

public interface MenuService {
    Menu findMenuById(Integer id);

    PageResult pageQuery(QueryPageBean queryPageBean);

    List<Menu> findAll();

}
