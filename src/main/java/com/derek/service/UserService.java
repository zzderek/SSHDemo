package com.derek.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import com.derek.dao.impl.UserDaoImpl;
import com.derek.model.User;
import com.derek.utils.RedisUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
@Service
public class UserService {
    Logger logger = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private UserDaoImpl userDao;
    @Autowired
    private RedisUtils redisUtils;

    public User getUserById(Integer id){
        String  userJson = (String)redisUtils.get("user:"+String.valueOf(id));
        User user = JSON.parseObject(userJson, User.class);
        if(user != null){
            logger.info("从redis缓存查询到的User信息："+user.toString());
        }else{
            logger.info("缓存中查无对象User信息，,开始查询数据库");
            user = userDao.findUserById(id);
            if(user != null){
                logger.info("缓存user信息："+user.toString());
                redisUtils.set("user:"+String.valueOf(id), JSON.toJSONString(user));
            }

        }
        return user;
    }

    public void saveUser(User user) {
        userDao.saveUser(user);

    }
}
