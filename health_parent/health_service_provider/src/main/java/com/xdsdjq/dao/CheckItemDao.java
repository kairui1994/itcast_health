package com.xdsdjq.dao;

import com.xdsdjq.pojo.CheckItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author HQ
 * @date 2020/8/13 16:21
 */
public interface CheckItemDao {

    void add(CheckItem checkItem);

    List<CheckItem> selectByCondition(@Param("queryString") String queryString);

    long findCountByCheckItemId(Integer id);

    void deleteById(Integer id);

    CheckItem findById(@Param("id") Integer id);

    void edit(CheckItem checkItem);

    List<CheckItem> findAll();
}
