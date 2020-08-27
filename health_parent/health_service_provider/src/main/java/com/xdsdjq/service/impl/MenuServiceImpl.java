package com.xdsdjq.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xdsdjq.dao.MenuDao;
import com.xdsdjq.pojo.Menu;
import com.xdsdjq.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Service(interfaceClass = MenuService.class)
@Transactional
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDao  menuDao;

    public Menu findMenuById(Integer id) {
        return menuDao.findMenuById(id);
    }
}
