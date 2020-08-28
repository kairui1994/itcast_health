package com.xdsdjq.service;

import com.xdsdjq.pojo.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAll();

    void add(Role role, Integer[] permissionIds);

    Role findById(Integer id);

    List<Integer> findPermissionByRoleId(Integer id);

    void edit(Role role, Integer[] permissionIds);

    void deleteRole(Integer id);

    void addPermission(Integer[] permissionIds, Integer id);
}
