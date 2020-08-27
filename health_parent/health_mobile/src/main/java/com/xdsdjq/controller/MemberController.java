package com.xdsdjq.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xdsdjq.constant.MessageConstant;
import com.xdsdjq.constant.RedisMessageConstant;
import com.xdsdjq.entity.PageResult;
import com.xdsdjq.entity.QueryPageBean;
import com.xdsdjq.entity.Result;
import com.xdsdjq.pojo.Member;
import com.xdsdjq.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.JedisPool;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private JedisPool jedisPool;

    @Reference
    private MemberService memberService;

    //使用手机号和验证码登录
    @RequestMapping("/login")
    public Result login(HttpServletResponse response, @RequestBody Map map) {
        String telephone = (String) map.get("telephone");
        String validateCode = (String) map.get("validateCode");

        //从redis中取出验证码比对
        String codeInRedis = jedisPool.getResource().get(telephone + telephone + RedisMessageConstant.SENDTYPE_LOGIN);

        if (validateCode != null && codeInRedis != null && validateCode.equals(codeInRedis)) {
            //验证码比对成功，判断是否为会员，若不是会员自动注册成会员
            Member member = memberService.findByTelephone(telephone);
            if (member == null) {
                //不是会员，自动注册成会员
                member = new Member();
                member.setPhoneNumber(telephone);
                member.setRegTime(new Date());
                memberService.add(member);
            }
        } else {
            return new Result(false, MessageConstant.VALIDATECODE_ERROR);
        }
        return null;
    }
}
