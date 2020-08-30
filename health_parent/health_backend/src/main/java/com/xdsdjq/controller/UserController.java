package com.xdsdjq.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xdsdjq.constant.MessageConstant;
import com.xdsdjq.entity.PageResult;
import com.xdsdjq.entity.QueryPageBean;
import com.xdsdjq.entity.Result;
import com.xdsdjq.pojo.User;
import com.xdsdjq.service.RoleService;
import com.xdsdjq.service.UserService;
import org.junit.Test;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Reference
    private UserService userService;

    @Reference
    private RoleService roleService;

    @RequestMapping("/getUsername")
    public Result getUsername() throws Exception {
        try {
            org.springframework.security.core.userdetails.User user =
                    (org.springframework.security.core.userdetails.User)
                            SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            return new Result(true, MessageConstant.GET_USERNAME_SUCCESS, user.getUsername());
        } catch (Exception e) {
            return new Result(false, MessageConstant.GET_USERNAME_FAIL);
        }
    }

    @RequestMapping("/getPath")
    public Result getPath(String username) {
        try {
            List<Object> list = userService.getPathByUsername(username);
            return new Result(true, MessageConstant.GET_MENU_SUCCESS, list);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.GET_MENU_FAIL);
        }
    }

    @RequestMapping("/findPage")
    public PageResult findPage(@RequestBody QueryPageBean queryPageBean) {
        PageResult pageResult = null;
        try {
            pageResult = userService.pageQuery(queryPageBean);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pageResult;
    }

    @RequestMapping("/add")
    public Result add(Integer[] roleIds, @RequestBody User user) {
        try {
            userService.add(user, roleIds);
            return new Result(true, MessageConstant.ADD_USER_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.ADD_USER_FAIL);
        }
    }

    @RequestMapping("/findById")
    public Result findById(Integer id) {
        try {
            User user = userService.findById(id);
            return new Result(true, MessageConstant.GET_USER_SUCCESS, user);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.GET_USER_FAIL);
        }
    }

    @RequestMapping("/edit")
    public Result edit(Integer[] roleIds,@RequestBody User user) {
        try {
            userService.edit(roleIds,user);
            return new Result(true, MessageConstant.EDIT_USER_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.EDIT_USER_FAIL);
        }
    }

    @RequestMapping("/delete")
    public Result delete(Integer id) {
        try {
            userService.deleteById(id);
            return new Result(true, MessageConstant.DELETE_USER_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.DELETE_USER_FAIL);
        }
    }

    @RequestMapping("/getLoginStatus")
    public Result getLoginStatus(HttpServletRequest request, HttpServletResponse response) {

        Boolean flag = (Boolean) request.getSession().getAttribute("result");

        request.getSession().removeAttribute("result");
        if (flag) {
            return new Result(true, "登录成功！");
        } else {
            return new Result(flag, "登录失败，请检查用户名和密码！");
        }
    }

    @RequestMapping("/addRoleByUserId")
    public Result addRoleByUserId(Integer[] roleIds,Integer userId){
        try {
            userService.addRoleByUserId(roleIds,userId);
            return new Result(true,MessageConstant.GRANT_ROLE_SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,MessageConstant.GRANT_ROLE_FAIL);
        }

    }
}