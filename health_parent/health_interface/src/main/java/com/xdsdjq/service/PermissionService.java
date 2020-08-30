package com.xdsdjq.service;

import com.xdsdjq.entity.PageResult;
import com.xdsdjq.entity.QueryPageBean;
import com.xdsdjq.pojo.Permission;

import java.util.List;

public interface PermissionService {

    List<Permission> findAll();

    PageResult pageQuery(QueryPageBean queryPageBean);

    void add(Permission permission) throws Exception;

    Permission findById(int id);

    void edit(Permission permission);

    void deleteById(int id);
}
