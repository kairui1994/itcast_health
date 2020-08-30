package com.xdsdjq.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xdsdjq.constant.MessageConstant;
import com.xdsdjq.entity.PageResult;
import com.xdsdjq.entity.QueryPageBean;
import com.xdsdjq.entity.Result;
import com.xdsdjq.pojo.Permission;
import com.xdsdjq.service.PermissionService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/permission")
public class PermissionController {
    @Reference
    private PermissionService permissionService;

    @RequestMapping("/findPermission")
    public Result findAll() {
        try {
            List<Permission> list = permissionService.findAll();
            return new Result(true, MessageConstant.QUERY_PERMISSION_SUCCESS, list);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.QUERY_PERMISSION_FAIL);
        }
    }

    //分页查询
    @RequestMapping("/pageQuery")
    public PageResult findPage(@RequestBody QueryPageBean queryPageBean) {
        PageResult pageResult = permissionService.pageQuery(queryPageBean);
        return pageResult;
    }
    //新增权限
    @RequestMapping("/add")
    @PreAuthorize("hasAuthority('ROLE_ADD')")
    public Result addCheckItem(@RequestBody Permission permission) {
        try {
            permissionService.add(permission);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.ADD_PERMISSION_FAIL);
        }
        return new Result(true, MessageConstant.ADD_PERMISSION_SUCCESS);
    }
    //通过ID查询
    @RequestMapping("/findById")
    public Result findById(int id) {
        Permission permission = null;
        try {
            permission = permissionService.findById(id);
        } catch (Exception e) {
            return new Result(false, MessageConstant.EDIT_PERMISSION_FAIL);
        }
        return new Result(true, MessageConstant.EDIT_PERMISSION_SUCCESS, permission);
    }
    @RequestMapping("/edit")
    @PreAuthorize("hasAuthority('ROLE_EDIT')")
    public Result edit(@RequestBody Permission permission) {
        try {
            permissionService.edit(permission);
        } catch (Exception e) {
            return new Result(false, MessageConstant.EDIT_PERMISSION_FAIL);
        }
        return new Result(true, MessageConstant.EDIT_PERMISSION_SUCCESS);
    }
    //删除检查项
    @RequestMapping("/delete.do")
    @PreAuthorize("hasAuthority('ROLE_DELETE')")
    public Result delete(int id) {
        try {
            permissionService.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.DELETE_PERMISSION_FAIL);
        }
        return new Result(true, MessageConstant.DELETE_PERMISSION_SUCCESS);
    }
}


