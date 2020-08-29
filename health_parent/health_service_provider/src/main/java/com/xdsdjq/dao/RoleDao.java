package com.xdsdjq.dao;

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

    void addRoleByUserId(@Param("userId") Integer userId, @Param("roleId") Integer roleId);

    List<Integer> findRoleIdsByUserId(int userId);

    void setRoleAndMenu(@Param("id") Integer id, @Param("menuId") Integer menuId);

    List<Integer> findMenuByRoleId(Integer id);

    void deleteRoleAndMenu(Integer id);
}
