package com.xdsdjq.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xdsdjq.dao.RoleDao;
import com.xdsdjq.pojo.Permission;
import com.xdsdjq.pojo.Role;
import com.xdsdjq.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(interfaceClass = RoleService.class)
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    // 查询所有
    @Override
    public List<Role> findAll() {
        return roleDao.findAll();
    }

    //添加
    @Override
    public void add(Role role, Integer[] permissionIds) {
        roleDao.add(role);
        Integer id = role.getId();
        setRoleAndPermission(id, permissionIds);
    }
    // 设置中间表关系
    public void setRoleAndPermission(Integer id,Integer[] permissionIds){
        if (permissionIds != null && permissionIds.length > 0) {
            for (Integer permissionId : permissionIds) {
                roleDao.setRoleAndPermission(id, permissionId);
            }
        }
    }

    @Override
    public Role findById(Integer id) {
        return roleDao.findById(id);
    }

    @Override
    public List<Integer> findPermissionByRoleId(Integer id) {
        return roleDao.findPermissionByRoleId(id);
    }

    @Override
    public void edit(Role role, Integer[] permissionIds) {
        roleDao.edit(role);
        Integer id = role.getId();
        // 删除中间表信息
        roleDao.deleteRoleAndPermission(id);
        // 设置中间表信息
        setRoleAndPermission(id, permissionIds);
    }

    @Override
    public void deleteRole(Integer id) {
        roleDao.deleteRoleAndPermission(id);
        roleDao.deleteRole(id);
    }

    @Override
    public void addPermission(Integer[] permissionIds, Integer id) {
        roleDao.deleteRoleAndPermission(id);
        setRoleAndPermission(id, permissionIds);
    }
}
