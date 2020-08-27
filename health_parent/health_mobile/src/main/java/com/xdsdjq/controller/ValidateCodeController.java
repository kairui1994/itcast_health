package com.xdsdjq.controller;

import com.xdsdjq.constant.MessageConstant;
import com.xdsdjq.constant.RedisMessageConstant;
import com.xdsdjq.entity.Result;
import com.xdsdjq.utils.SMSUtils;
import com.xdsdjq.utils.ValidateCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.JedisPool;

@RestController
@RequestMapping("/validateCode")
public class ValidateCodeController {

    @Autowired
    private JedisPool jedisPool;

    //发送预约验证码
    @RequestMapping("/send4Order")
    public Result send4Order(String telephone) {
        //生成验证码
        Integer code = ValidateCodeUtils.generateValidateCode(4);
        try {
            //SMSUtils.sendShortMessage(SMSUtils.VALIDATE_CODE,telephone,code.toString());
            System.out.println("预约验证码：" + code);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.SEND_VALIDATECODE_FAIL);
        }
        //将验证码保存到redis中
        jedisPool.getResource().setex(telephone + RedisMessageConstant.SENDTYPE_ORDER, 5 * 60, code.toString());
        return new Result(true, MessageConstant.SEND_VALIDATECODE_SUCCESS);
    }

    //发送登录验证码
    @RequestMapping("/send4Login")
    public Result send4Login(String telephone) {
        Integer code = ValidateCodeUtils.generateValidateCode(6);
        try {
            //SMSUtils.sendShortMessage(SMSUtils.LOGIN_CODE,telephone,code.toString());
            System.out.println("登录验证码：" + code);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.SEND_VALIDATECODE_FAIL);
        }
        //将验证码保存到redis中
        jedisPool.getResource().setex(telephone + RedisMessageConstant.SENDTYPE_LOGIN, 5 * 60, code.toString());
        return new Result(true, MessageConstant.SEND_VALIDATECODE_SUCCESS);
    }
}
