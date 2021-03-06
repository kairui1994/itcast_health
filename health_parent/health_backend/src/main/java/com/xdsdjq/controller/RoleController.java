package com.xdsdjq.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xdsdjq.constant.MessageConstant;
import com.xdsdjq.entity.Result;
import com.xdsdjq.pojo.Role;
import com.xdsdjq.service.RoleService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Reference
    private RoleService roleService;

    @RequestMapping("/findAll")
    public Result findAll() {
        try {
            List<Role> list = roleService.findAll();
            return new Result(true, MessageConstant.ADD_ROLE_SUCCESS, list);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.QUERY_ROLE_FAIL);
        }
    }
    @RequestMapping("/add")
    public Result add(@RequestBody Role role, Integer[] permissionIds,Integer[] menuIds) {
        try {
            roleService.add(role, permissionIds,menuIds);
            return new Result(true, MessageConstant.ADD_ROLE_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.ADD_ROLE_FAIL);
        }
    }

    @RequestMapping("/findById")
    public Result findById(Integer id) {
        try {
            Role role = roleService.findById(id);
            return new Result(true, MessageConstant.QUERY_ROLE_SUCCESS, role);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.QUERY_ROLE_FAIL);
        }
    }

    @RequestMapping("/findPermissionByRoleId")
    public Result findPermissionByRoleId(Integer id) {
        try {
            List<Integer> list = roleService.findPermissionByRoleId(id);
            return new Result(true, MessageConstant.QUERY_PERMISSION_SUCCESS, list);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.QUERY_PERMISSION_FAIL);
        }
    }

    @RequestMapping("/edit")
    public Result edit(@RequestBody Role role, Integer[] permissionIds,Integer[] menuIds) {
        try {
            roleService.edit(role, permissionIds,menuIds);
            return new Result(true, MessageConstant.EDIT_ROLE_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.EDIT_PERMISSION_FAIL);
        }
    }

    @RequestMapping("/delete")
    public Result delete(Integer id) {
        try {
            roleService.deleteRole(id);
            return new Result(true, MessageConstant.DELETE_ROLE_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.DELETE_ROLE_FAIL);
        }
    }

    @RequestMapping("/addPermission")
    public Result addPermission(Integer[] permissionIds, Integer id) {

        try {
            roleService.addPermission(permissionIds, id);
            return new Result(true, MessageConstant.ADD_PERMISSION_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.ADD_PERMISSION_FAIL);
        }
    }

    @RequestMapping("/findRoleIdsByUserId")
    public Result findRoleIdsByUserId(Integer userId) {
        try {
            List<Integer> roles = roleService.findRoleIdsByUserId(userId);
            return new Result(true, MessageConstant.QUERY_ROLE_SUCCESS, roles);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.QUERY_ROLE_FAIL);
        }
    }

    @RequestMapping("/findMenuByRoleId")
    public Result findMenuByRoleId(Integer id) {
        try {
            List<Integer> list = roleService.findMenuByRoleId(id);
            return new Result(true, MessageConstant.QUERY_MENU_SUCCESS, list);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.QUERY_MENU_FAIL);
        }
    }
}
