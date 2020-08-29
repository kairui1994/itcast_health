package com.xdsdjq.service;

import com.xdsdjq.entity.PageResult;
import com.xdsdjq.entity.QueryPageBean;
import com.xdsdjq.pojo.SetMeal;

import java.util.List;
import java.util.Map;

public interface SetMealService {
    void add(SetMeal setmeal, Integer[] checkGroupIds);

    PageResult findPage(QueryPageBean queryPageBean);

    SetMeal findById(Integer id);

    List<Integer> findSetMealAndCheckGroupById(Integer id);

    void edit(SetMeal setmeal, Integer[] checkGroupIds);

    void delete(Integer id);

    List<SetMeal> getAllSetMeal();

    List<Map<String, Object>> findSetMealCount();

    List<SetMeal> findAll();
}
