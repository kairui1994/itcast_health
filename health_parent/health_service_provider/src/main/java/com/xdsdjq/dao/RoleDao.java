package com.xdsdjq.dao;


import com.xdsdjq.pojo.Permission;
import com.xdsdjq.pojo.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

public interface RoleDao {
    Set<Role> findRoleByUserId(Integer userId);

    List<Role> findAll();

    void add(Role role);

    void setRoleAndPermission(@Param("id") Integer id, @Param("permissionId") Integer permissionId);

    Role findById(Integer id);

    List<Integer> findPermissionByRoleId(Integer id);

    void edit(Role role);

    void deleteRoleAndPermission(Integer id);

    void deleteRole(Integer id);
}
