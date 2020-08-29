package com.xdsdjq.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xdsdjq.dao.MenuDao;
import com.xdsdjq.entity.PageResult;
import com.xdsdjq.entity.QueryPageBean;
import com.xdsdjq.pojo.CheckItem;
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

    @Override
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
}
