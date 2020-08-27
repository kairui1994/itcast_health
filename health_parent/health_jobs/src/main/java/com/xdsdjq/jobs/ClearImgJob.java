package com.xdsdjq.jobs;


import com.xdsdjq.constant.RedisConstant;
import com.xdsdjq.utils.QiNiuUtils;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.JedisPool;
import java.util.Set;



public class ClearImgJob {
    @Autowired
    private JedisPool jedisPool;

    public void clearImg(){
        //计算七牛云数据与本地数据库中数据的差集
        Set<String> set = jedisPool.getResource().sdiff(RedisConstant.SETMEAL_PIC_RESOURCES, RedisConstant.SETMEAL_PIC_DB_RESOURCES);
        for (String imgName : set) {

            //删除七牛云中的图片
            QiNiuUtils.deleteFileFromQiNiu(imgName);
            System.out.println("删除七牛云图片成功:"+imgName);

            //删除本地Redis中的数据
            jedisPool.getResource().srem(RedisConstant.SETMEAL_PIC_RESOURCES,imgName);
            System.out.println("从redis中删除的图片成功："+imgName);
        }

    }
}
