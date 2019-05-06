package com.derek.test;

import com.derek.model.User;
import com.derek.service.UserService;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@Transactional
public class UserTest {

    @Autowired
    private UserService userService;

    @Test
    public void testGetAcccountById() {

        List<User> userList = userService.getUserById(1);
        String userName = userList.get(0).getUserName();
        assertEquals(userName,"ii");
    }

    @Test
    public void testConn() {
        //读取hibernate.cfg.xml中的配置信息
        Configuration config = new Configuration();
        config.configure();
        //获取数据库的连接池
        SessionFactory factory = config.buildSessionFactory();
        System.out.println(factory);
    }

}
