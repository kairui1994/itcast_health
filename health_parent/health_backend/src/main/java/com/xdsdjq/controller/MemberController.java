package com.xdsdjq.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xdsdjq.constant.MessageConstant;
import com.xdsdjq.entity.PageResult;
import com.xdsdjq.entity.QueryPageBean;
import com.xdsdjq.entity.Result;
import com.xdsdjq.pojo.Member;
import com.xdsdjq.service.MemberService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequestMapping("/member")
@RestController
public class MemberController {

    @Reference
    private MemberService memberService;

    @RequestMapping("/findPage")
    public PageResult findPage(@RequestBody QueryPageBean queryPageBean) {
        PageResult pageResult = null;
        try {
            pageResult = memberService.pageQuery(queryPageBean);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pageResult;
    }

    @RequestMapping("/findById")
    public Result findById(Integer id){
        try {
          Member member = memberService.findById(id);
          return new Result(true, MessageConstant.QUERY_MEMBER_SUCCESS,member);
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false, MessageConstant.QUERY_MEMBER_FAIL);
        }

    }

    @RequestMapping("/edit")
    public Result edit(@RequestBody Member member){

        return null;
    }

    @RequestMapping("/add")
    public Result add(@RequestBody Member member){
        try {
            memberService.add(member);
            return new Result(true,MessageConstant.ADD_MEMBER_SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,MessageConstant.ADD_MEMBER_FAIL);
        }
    }
    @RequestMapping("/changeStatus")
    public Result changeStatus(@RequestBody Map map){
        try {
            memberService.changeStatus(map);
            return new Result(true,MessageConstant.EDIT_FAIL);
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,MessageConstant.EDIT_SUCCESS);
        }
    }
}
