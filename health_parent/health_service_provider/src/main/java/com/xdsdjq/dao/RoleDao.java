package com.xdsdjq.dao;


import com.xdsdjq.pojo.Role;

import java.util.Set;

public interface RoleDao {
    Set<Role> findRoleByUserId(Integer userId);
}
