package com.xdsdjq.dao;

import com.xdsdjq.pojo.CheckItem;
import com.xdsdjq.pojo.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuDao {
    Menu findMenuById(Integer id);

    List<Menu> selectByCondition(@Param("queryString") String queryString);

    List<Menu> findAll();

    void add(Menu menu);

    void addRoleByMenuId(@Param("roleId") Integer roleId, @Param("menuId") Integer menuId);

    List<Integer> findRoleIdsByMenuId(@Param("menuId") Integer menuId);
}
