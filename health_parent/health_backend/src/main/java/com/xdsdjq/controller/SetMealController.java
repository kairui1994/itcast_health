package com.xdsdjq.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xdsdjq.constant.MessageConstant;
import com.xdsdjq.constant.RedisConstant;
import com.xdsdjq.entity.PageResult;
import com.xdsdjq.entity.QueryPageBean;
import com.xdsdjq.entity.Result;
import com.xdsdjq.pojo.SetMeal;
import com.xdsdjq.service.SetMealService;
import com.xdsdjq.utils.QiNiuUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import redis.clients.jedis.JedisPool;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/setMeal")
public class SetMealController {

    //使用JedisPool操作Redis服务
    @Autowired
    private JedisPool jedisPool;

    @Reference
    private SetMealService setMealService;

    //文件上传
    @RequestMapping("/upload")
    public Result upload(@RequestParam("imgFile") MultipartFile imgFile) {
        String originalFilename = imgFile.getOriginalFilename();//原始文件名 3bd90d2c-4e82-42a1-a401-882c88b06a1a2.jpg
        int index = originalFilename.lastIndexOf(".");//获取文件名中最后一个点的位置
        String extension = originalFilename.substring(index - 1);//.jpg 截取文件后缀
        String fileName = UUID.randomUUID().toString().replace("-", "") + extension;
        try {
            //将文件上传到七牛云服务器
            QiNiuUtils.upload2QiNiu(imgFile.getBytes(), fileName);
            //将文件名称保存到redis中
            jedisPool.getResource().sadd(RedisConstant.SETMEAL_PIC_RESOURCES, fileName);
        } catch (IOException e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.PIC_UPLOAD_FAIL);
        }
        return new Result(true, MessageConstant.PIC_UPLOAD_SUCCESS, fileName);
    }




    @RequestMapping("/add")
    public Result add(@RequestBody SetMeal setmeal, Integer[] checkGroupIds) {
        try {
            setMealService.add(setmeal, checkGroupIds);
            return new Result(true, MessageConstant.ADD_SETMEAL_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.ADD_SETMEAL_FAIL);
        }
    }

    @RequestMapping("/edit")
    public Result edit(@RequestBody SetMeal setmeal, Integer[] checkGroupIds) {
        try {
            setMealService.edit(setmeal, checkGroupIds);
            return new Result(true, MessageConstant.EDIT_SETMEAL_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.EDIT_SETMEAL_FAIL);
        }
    }

    @RequestMapping("/findPage")
    public PageResult findPage(@RequestBody QueryPageBean queryPageBean) {
        try {
            PageResult pageResult = setMealService.findPage(queryPageBean);
            return pageResult;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping("/findById")
    public Result findById(Integer id) {
        try {
            SetMeal setMeal = setMealService.findById(id);
            return new Result(true,MessageConstant.QUERY_SETMEAL_SUCCESS,setMeal);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(true,MessageConstant.QUERY_SETMEAL_FAIL);
        }
    }

    @RequestMapping("/findSetMealAndCheckGroupById")
    public Result findSetMealAndCheckGroupById(Integer id){
        try{
            List<Integer> list = setMealService.findSetMealAndCheckGroupById(id);
            return new Result(true,MessageConstant.QUERY_SETMEALLIST_SUCCESS,list);
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,MessageConstant.QUERY_SETMEALLIST_FAIL);
        }
    }

    @RequestMapping("/delete")
    public Result delete(Integer id){
        try {
            setMealService.delete(id);
            return new Result(true,MessageConstant.DELETE_SETMEAL_SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,MessageConstant.DELETE_SETMEAL_FAIL);
        }
    }


}
