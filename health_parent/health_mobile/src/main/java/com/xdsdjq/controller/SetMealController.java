package com.xdsdjq.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xdsdjq.constant.MessageConstant;
import com.xdsdjq.entity.Result;
import com.xdsdjq.pojo.SetMeal;
import com.xdsdjq.service.SetMealService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/setMeal")
public class SetMealController {

    @Reference
    private SetMealService setMealService;

    /**
     * 查询所有套餐
     * @return
     */
    @RequestMapping("/getAllSetMeal")
    public Result getAllSetMeal() {
        try {
            List<SetMeal> list = setMealService.getAllSetMeal();
            return new Result(true, MessageConstant.GET_SETMEAL_LIST_SUCCESS, list);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.GET_SETMEAL_LIST_FAIL);
        }
    }

    /**
     * 根据套餐id查询套餐详情 包含检查组 和检查项
     * @param id
     * @return
     */
    @RequestMapping("/findById")
    public Result findById(Integer id){
        try {
            SetMeal setMeal = setMealService.findById(id);
            return new Result(true,MessageConstant.QUERY_SETMEAL_SUCCESS,setMeal);
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,MessageConstant.QUERY_SETMEAL_FAIL);
        }
    }

}
