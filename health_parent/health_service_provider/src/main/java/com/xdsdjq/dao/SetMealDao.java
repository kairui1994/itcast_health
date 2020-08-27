package com.xdsdjq.dao;

import com.xdsdjq.pojo.SetMeal;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SetMealDao {
    void addSetMeal(SetMeal setmeal);

    void setSetMealAndCheckGroup(@Param("setMealId") int setMealId, @Param("checkGroupId") Integer checkGroupId);

    List<SetMeal> findPage(@Param("queryString") String queryString);

    SetMeal selectByPrimaryKey(Integer id);

    List<Integer> findSetMealAndCheckGroupById(Integer id);

    void updateSetMealByPrimaryKey(SetMeal setmeal);

    void deleteSetMealAndGroup(Integer id);

    void deleteByPrimaryKey(Integer id);

    List<SetMeal> getAllSetMeal();

    SetMeal findById(Integer id);

    List<Map<String, Object>> findSetMealCount();
}
