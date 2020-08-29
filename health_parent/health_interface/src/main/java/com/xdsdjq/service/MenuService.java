package com.xdsdjq.service;

import com.xdsdjq.entity.PageResult;
import com.xdsdjq.entity.QueryPageBean;
import com.xdsdjq.pojo.Menu;

public interface MenuService {
    Menu findMenuById(Integer id);

    PageResult pageQuery(QueryPageBean queryPageBean);
}
