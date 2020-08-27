package com.xdsdjq.service;

import com.xdsdjq.entity.PageResult;
import com.xdsdjq.entity.QueryPageBean;
import com.xdsdjq.pojo.CheckGroup;

import java.util.List;

public interface CheckGroupService {

    void add(CheckGroup checkGroup, Integer[] checkItemIds);

    PageResult pageQuery(QueryPageBean queryPageBean);

    void deleteById(Integer id);

    CheckGroup findById(Integer id);

    List<Integer> findCheckItemIdByGId(Integer id);

    void edit(CheckGroup checkGroup, Integer[] checkItemIds);

    List<CheckGroup> findAll();
}
