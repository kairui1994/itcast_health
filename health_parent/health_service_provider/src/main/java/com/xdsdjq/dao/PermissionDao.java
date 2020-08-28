package com.xdsdjq.dao;

import com.xdsdjq.pojo.Permission;

import java.util.List;
import java.util.Set;

public interface PermissionDao {

    Set<Permission> findPermissionByRoleId(Integer roleId);

    List<Permission> findAll();
}
