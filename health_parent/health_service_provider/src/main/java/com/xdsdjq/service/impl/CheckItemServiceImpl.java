package com.xdsdjq.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xdsdjq.dao.CheckItemDao;
import com.xdsdjq.entity.PageResult;
import com.xdsdjq.entity.QueryPageBean;
import com.xdsdjq.pojo.CheckItem;
import com.xdsdjq.service.CheckItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * @author HQ
 * @date 2020/8/13 16:18
 */
@Service(interfaceClass = CheckItemService.class)
@Transactional
public class CheckItemServiceImpl implements CheckItemService {


    @Autowired
    private CheckItemDao checkItemDao;

    /**
     * 新增检查项
     *
     * @param checkItem
     */
    public void add(CheckItem checkItem) {
        checkItemDao.add(checkItem);
    }

    /**
     * 检查项分页查询
     * @param queryPageBean
     * @return
     */
    public PageResult pageQuery(QueryPageBean queryPageBean) {
        Integer currentPage = queryPageBean.getCurrentPage();
        Integer pageSize = queryPageBean.getPageSize();

        String queryString = queryPageBean.getQueryString();

        //完成分页查询，mybatis分页助手
        PageHelper.startPage(currentPage,pageSize);

        List<CheckItem> list = checkItemDao.selectByCondition(queryString);
        PageInfo page = new PageInfo(list);

        long total = page.getTotal();
        List data = page.getList();
        return new PageResult(total,data);
    }

    /**
     * 根据id删除检查项
     * @param id
     */
    public void deleteById(Integer id) {
        //判断当前检查项是否关联检查组

        long count = checkItemDao.findCountByCheckItemId(id);
        if (count>0){
            //当前检查项已经关联检查组，不允许删除
            new RuntimeException();
        }

        checkItemDao.deleteById(id);
    }

    /**
     * 根据id查询检查项
     * @param id
     * @return
     */
    public CheckItem findById(Integer id) {
        return checkItemDao.findById(id);
    }

    /**
     * 编辑检查项
     * @param checkItem
     */
    public void edit(CheckItem checkItem) {
        checkItemDao.edit(checkItem);
    }

    public List<CheckItem> findAll() {
        return checkItemDao.findAll();
    }
}
