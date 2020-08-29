package com.xdsdjq.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xdsdjq.dao.RoleDao;
import com.xdsdjq.dao.UserDao;
import com.xdsdjq.entity.PageResult;
import com.xdsdjq.entity.QueryPageBean;
import com.xdsdjq.pojo.Menu;
import com.xdsdjq.pojo.Role;
import com.xdsdjq.pojo.User;
import com.xdsdjq.service.UserService;
import com.xdsdjq.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service(interfaceClass = UserService.class)
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    public User findByUsername(String username) {
        User user = userDao.findByUsername(username);
        return user;
    }

    @Override
    public List<Object> getPathByUsername(String username) {
        List<Object> list = new ArrayList<>();
        User user = userDao.findByUsername(username);
        Set<Role> roles = user.getRoles();
        Map<String, Object> map = null;
        for (Role role : roles) {
            LinkedHashSet<Menu> menus = role.getMenus();
            for (Menu menu : menus) {
                map = new HashMap<>();
                List<Menu> childrenList = menu.getChildren();
                List<Object> children = null;
                if (childrenList != null && childrenList.size() > 0) {
                    children = new ArrayList<>();
                    for (Menu childMenu : childrenList) {
                        Map<String, Object> map2 = new HashMap<>();
                        map2.put("icon", childMenu.getIcon());
                        map2.put("title", childMenu.getName());
                        map2.put("path", childMenu.getPath());
                        map2.put("linkUrl", childMenu.getLinkUrl());
                        map2.put("children", null);
                        children.add(map2);
                    }
                    map.put("icon", menu.getIcon());
                    map.put("title", menu.getName());
                    map.put("path", menu.getPath());
                    map.put("linkUrl", menu.getLinkUrl());
                    map.put("children", children);
                }
                if (map != null && map.size() > 0)
                    list.add(map);
            }
        }
        return list;
    }

    @Override
    public PageResult pageQuery(QueryPageBean queryPageBean) {

        Integer currentPage = queryPageBean.getCurrentPage();
        Integer pageSize = queryPageBean.getPageSize();

        String queryString = queryPageBean.getQueryString();

        //完成分页查询，mybatis分页助手
        PageHelper.startPage(currentPage, pageSize);

        List<User> list = userDao.selectByCondition(queryString);

        PageInfo page = new PageInfo(list);
        long total = page.getTotal();
        List data = page.getList();
        return new PageResult(total, data);
    }

    @Override
    public void add(User user,int[] roleIds) {
        user.setPassword(MD5Utils.passwordEncoder(user.getPassword()));
        userDao.add(user);
        Integer userId = user.getId();

        for (int roleId : roleIds) {
            roleDao.addRoleByUserId(userId,roleId);
        }

    }

    @Override
    public User findById(Integer id) {
        return userDao.findById(id);
    }

    @Override
    public void edit(User user) {
        String password = findById(user.getId()).getPassword();
        String editPassword = user.getPassword();

        if (editPassword != null && !(editPassword.equals(password))) {
            user.setPassword(MD5Utils.passwordEncoder(editPassword));
        }
        userDao.edit(user);
    }

    @Override
    public void deleteById(Integer userId) {
        userDao.deleteRoleByUseId(userId);
        userDao.deleteById(userId);
    }
}
