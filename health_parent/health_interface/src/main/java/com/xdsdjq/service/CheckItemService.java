package com.xdsdjq.service;

import com.xdsdjq.entity.PageResult;
import com.xdsdjq.entity.QueryPageBean;
import com.xdsdjq.pojo.CheckItem;

import java.util.List;

/**
 * @author HQ
 * @date 2020/8/13 15:53
 */
public interface CheckItemService {
    void add(CheckItem checkItem);

    PageResult pageQuery(QueryPageBean queryPageBean);

    void deleteById(Integer id);

    CheckItem findById(Integer id);

    void edit(CheckItem checkItem);

    List<CheckItem> findAll();
}
