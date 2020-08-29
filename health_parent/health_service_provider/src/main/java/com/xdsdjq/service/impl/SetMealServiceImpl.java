package com.xdsdjq.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xdsdjq.constant.RedisConstant;
import com.xdsdjq.dao.SetMealDao;
import com.xdsdjq.entity.PageResult;
import com.xdsdjq.entity.QueryPageBean;
import com.xdsdjq.pojo.SetMeal;
import com.xdsdjq.service.SetMealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.JedisPool;
import java.util.List;
import java.util.Map;


@Service(interfaceClass = SetMealService.class)
@Transactional
public class SetMealServiceImpl implements SetMealService {


    @Autowired
    private SetMealDao setMealDao;

    @Autowired
    private JedisPool jedisPool;

    public void add(SetMeal setmeal, Integer[] checkGroupIds) {
        setMealDao.addSetMeal(setmeal);
        setSetMealAndCheckGroup(setmeal.getId(), checkGroupIds);

        //System.out.println("-===========" + setmeal.getImg());
        //将图片名称保存到Redis
        savePic2Redis(setmeal.getImg());

    }

    //将图片名称保存到Redis
    private void savePic2Redis(String img) {
        jedisPool.getResource().sadd(RedisConstant.SETMEAL_PIC_DB_RESOURCES, img);
    }


    //修改套餐
    public void edit(SetMeal setmeal, Integer[] checkGroupIds) {
        setMealDao.deleteSetMealAndGroup(setmeal.getId());
        setMealDao.updateSetMealByPrimaryKey(setmeal);
        setSetMealAndCheckGroup(setmeal.getId(), checkGroupIds);
        //将图片名称保存到Redis
        savePic2Redis(setmeal.getImg());

    }

    //删除套餐
    public void delete(Integer id) {
        setMealDao.deleteSetMealAndGroup(id);
        setMealDao.deleteByPrimaryKey(id);
    }

    //查询所有套餐
    public List<SetMeal> getAllSetMeal() {
        return setMealDao.getAllSetMeal();
    }

    //查询套餐统计数据，
    public List<Map<String, Object>> findSetMealCount() {
        return setMealDao.findSetMealCount();
    }

    @Override
    public List<SetMeal> findAll() {
        return setMealDao.findAll();
    }


    //分页查询
    public PageResult findPage(QueryPageBean queryPageBean) {
        Integer currentPage = queryPageBean.getCurrentPage();
        Integer pageSize = queryPageBean.getPageSize();
        String queryString = queryPageBean.getQueryString();

        PageHelper.startPage(currentPage, pageSize);
        List<SetMeal> list = setMealDao.findPage(queryString);
        PageInfo pageInfo = new PageInfo(list);
        long total = pageInfo.getTotal();
        List data = pageInfo.getList();
        return new PageResult(total, data);
    }

    //根据id查询套餐（套餐基本信息、套餐对应的检查组信息、检查组对应的检查项信息）
    public SetMeal findById(Integer id) {
        return setMealDao.findById(id);
    }

    @Override
    public List<Integer> findSetMealAndCheckGroupById(Integer id) {
        return setMealDao.findSetMealAndCheckGroupById(id);
    }


    private void setSetMealAndCheckGroup(int SetMealId, Integer[] checkGroupIds) {
        if (checkGroupIds != null && checkGroupIds.length > 0) {
            for (Integer checkGroupId : checkGroupIds) {
                setMealDao.setSetMealAndCheckGroup(SetMealId, checkGroupId);
            }
        }
    }
}
