package com.xdsdjq.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xdsdjq.dao.PermissionDao;
import com.xdsdjq.entity.PageResult;
import com.xdsdjq.entity.QueryPageBean;
import com.xdsdjq.pojo.Permission;
import com.xdsdjq.service.PermissionService;
import com.xdsdjq.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service(interfaceClass = PermissionService.class)
@Transactional
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionDao permissionDao;
    @Override
    public List<Permission> findAll() {
        return permissionDao.findAll();
    }

    @Override
    public PageResult pageQuery(QueryPageBean queryPageBean) {
        Integer currentPage = queryPageBean.getCurrentPage();
        Integer pageSize = queryPageBean.getPageSize();
        String queryString = queryPageBean.getQueryString();

        //使用分页助手
        PageHelper.startPage(currentPage, pageSize);
        Page<Permission> page = permissionDao.selectByCondition(queryString);
        long total = page.getTotal();
        List<Permission> rows = page.getResult();
        return new PageResult(total, rows);
    }
    @Override
    public void add(Permission permission) throws Exception {
        Date date = new Date();
        permission.setCreationdate(DateUtils.parseDate2String(date));
        permissionDao.add(permission);
    }

    @Override
    public Permission findById(int id) {
        return permissionDao.findById(id);
    }

    @Override
    public void edit(Permission permission) {
        permissionDao.edit(permission);
    }

    @Override
    public void deleteById(int id) {
        Long num = permissionDao.findRoleAndPermissionById(id);
        if (num > 0) {
            //不等于0表示已经关联角色 抛出异常
            System.out.println(3 / 0);
        } else {
            permissionDao.deleteById(id);
        }
    }
}
