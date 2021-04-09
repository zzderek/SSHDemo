package com.derek.test;


import com.derek.utils.RedisUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@Transactional
public class RedisTest {

    @Resource(name="redisTemplate")
    private RedisTemplate redisTemplate;
    @Autowired
    private RedisUtils redisUtils;

    @Test
    public void testStringRedis(){
        // stringRedisTemplate的操作
        // String读写
       // System.out.println(redisTemplate.opsForValue().get("name"));
        //redisTemplate.delete("name");
        redisTemplate.opsForValue().set("name", "zhou");
        System.out.println(redisTemplate.opsForValue().get("name"));
        System.out.println("---------------");
    }

    @Test
    public void testStringRedisByUtils(){
        String  name  = (String )redisUtils.get("name");
        System.out.println(name);
    }
}
