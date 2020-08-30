package com.xdsdjq.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xdsdjq.dao.MenuDao;
import com.xdsdjq.entity.PageResult;
import com.xdsdjq.entity.QueryPageBean;
import com.xdsdjq.pojo.Menu;
import com.xdsdjq.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(interfaceClass = MenuService.class)
@Transactional
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDao  menuDao;

    public Menu findMenuById(Integer id) {
        return menuDao.findMenuById(id);
    }


    public PageResult pageQuery(QueryPageBean queryPageBean) {
        Integer currentPage = queryPageBean.getCurrentPage();
        Integer pageSize = queryPageBean.getPageSize();

        String queryString = queryPageBean.getQueryString();

        //完成分页查询，mybatis分页助手
        PageHelper.startPage(currentPage,pageSize);

        List<Menu> list = menuDao.selectByCondition(queryString);
        PageInfo page = new PageInfo(list);

        long total = page.getTotal();
        List data = page.getList();
        return new PageResult(total,data);
    }

    @Override
    public List<Menu> findAll() {
        return menuDao.findAll();
    }

    /**
     * 添加菜单
     * @param menu
     * @param roleIds
     * @Author hq
     */
    @Override
    public void add(Menu menu, Integer[] roleIds) {
        menuDao.add(menu);
        Integer menuId = menu.getId();
        if (menuId!=null){
            for (Integer roleId : roleIds) {
                menuDao.addRoleByMenuId(roleId,menuId);
            }
        }
    }

    @Override
    public List<Integer> findRoleIdsByMenuId(Integer menuId) {

        List<Integer> roleIdsByMenuId = menuDao.findRoleIdsByMenuId(menuId);
        return roleIdsByMenuId;
    }
}
