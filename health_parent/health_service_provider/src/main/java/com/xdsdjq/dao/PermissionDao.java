package com.xdsdjq.dao;

import com.github.pagehelper.Page;
import com.xdsdjq.pojo.Permission;

import java.util.List;
import java.util.Set;

public interface PermissionDao {

    Set<Permission> findPermissionByRoleId(Integer roleId);

    List<Permission> findAll();

    Page<Permission> selectByCondition(String queryString);

    void add(Permission permission);

    Permission findById(int id);

    void edit(Permission permission);

    Long findRoleAndPermissionById(int id);

    void deleteById(int id);
}
