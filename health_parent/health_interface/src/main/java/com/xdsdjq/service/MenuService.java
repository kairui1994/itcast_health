package com.xdsdjq.service;

import com.xdsdjq.pojo.Menu;

import java.util.List;

public interface MenuService {
    Menu findMenuById(Integer id);

    List<Menu> findAll();
}
