package com.xdsdjq.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xdsdjq.constant.MessageConstant;
import com.xdsdjq.entity.PageResult;
import com.xdsdjq.entity.QueryPageBean;
import com.xdsdjq.entity.Result;
import com.xdsdjq.pojo.Menu;
import com.xdsdjq.service.MenuService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Reference
    private MenuService menuService;

    @RequestMapping("/findPage")
    public PageResult findPage(@RequestBody QueryPageBean queryPageBean) {
        PageResult pageResult = null;
        try {
            //pageResult = menuService.pageQuery(queryPageBean);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pageResult;
    }

    @RequestMapping("/findAll")
    public Result findAll() {
        try {
            List<Menu> list = menuService.findAll();
            return new Result(true, MessageConstant.QUERY_MENU_SUCCESS, list);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.QUERY_MENU_FAIL);
        }
    }
}
