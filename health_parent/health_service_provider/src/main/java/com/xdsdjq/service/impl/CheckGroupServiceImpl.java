package com.xdsdjq.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xdsdjq.dao.CheckGroupDao;
import com.xdsdjq.entity.PageResult;
import com.xdsdjq.entity.QueryPageBean;
import com.xdsdjq.pojo.CheckGroup;
import com.xdsdjq.service.CheckGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <!--通过Mybatis的selectKey便签获取最后添加的id-->
 * <selectKey resultType="integer" keyProperty="id" order="AFTER">
 * select LAST_INSERT_ID()
 * </selectKey>
 */

@Service(interfaceClass = CheckGroupService.class)
@Transactional
public class CheckGroupServiceImpl implements CheckGroupService {

    @Autowired
    private CheckGroupDao checkGroupDao;

    public void add(CheckGroup checkGroup, Integer[] checkItemIds) {
        //新增检查组 t_checkgroup 表
        checkGroupDao.addCheckGroup(checkGroup);
        //获取新插入记录的id值
        Integer checkGroupId = checkGroup.getId();
        setCheckGroupIdAndCheckItemId(checkItemIds, checkGroupId);
    }

    public void edit(CheckGroup checkGroup, Integer[] checkItemIds) {
        //编辑检查组
        checkGroupDao.editCheckGroup(checkGroup);
        Integer checkGroupId = checkGroup.getId();
        //编辑中间关联表
        editGroupAndItemsByCheckGroupId(checkGroupId, checkItemIds);
    }

    //查询所有
    public List<CheckGroup> findAll() {

        return checkGroupDao.findAll();
    }

    private void editGroupAndItemsByCheckGroupId(Integer checkGroupId, Integer[] checkItemIds) {
        if (checkItemIds != null && checkItemIds.length > 0) {
            checkGroupDao.deleteGroupAndItemByGroupId(checkGroupId);
            for (Integer checkItemId : checkItemIds) {
                checkGroupDao.addCheckGroupAndCheckItem(checkGroupId,checkItemId);
            }
        }
    }

    public PageResult pageQuery(QueryPageBean queryPageBean) {

        Integer currentPage = queryPageBean.getCurrentPage();
        Integer pageSize = queryPageBean.getPageSize();

        String queryString = queryPageBean.getQueryString();

        //完成分页查询，mybatis分页助手
        PageHelper.startPage(currentPage, pageSize);

        List<CheckGroup> list = checkGroupDao.selectByCondition(queryString);
        PageInfo page = new PageInfo(list);

        long total = page.getTotal();
        List data = page.getList();
        return new PageResult(total, data);
    }

    //删除检查组
    public void deleteById(Integer id) {
        checkGroupDao.deleteGroupAndItemByGroupId(id);
        checkGroupDao.deleteCheckGroupById(id);
    }

    //根据id查询检查组
    public CheckGroup findById(Integer id) {
        return checkGroupDao.findById(id);
    }

    public List<Integer> findCheckItemIdByGId(Integer id) {
        return checkGroupDao.findCheckItemIdByGId(id);
    }


    //设置关联
    private void setCheckGroupIdAndCheckItemId(Integer[] checkItemIds, Integer checkGroupId) {
        if (checkItemIds != null && checkItemIds.length > 0) {
            //checkItemIds需要插入到中间表 t_checkgroup_checkitem 表
            for (Integer checkItemId : checkItemIds) {
                checkGroupDao.addCheckGroupAndCheckItem(checkGroupId, checkItemId);
            }
        }
    }
}
