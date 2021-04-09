package com.derek.dao.impl;

import com.derek.dao.IUserDao;
import com.derek.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserDaoImpl implements IUserDao {

    @Autowired
    private SessionFactory sessionFactory;

    //获取和当前线程绑定的Seesion
    private Session getSession()
    {
        return sessionFactory.getCurrentSession();
    }

    public  User findUserById(int id) {
        String hql="FROM com.derek.model.User where id = ?";
        Query query=getSession().createQuery(hql);
        query.setParameter(0,id);
        User user = (User)query.uniqueResult(); // 查询单一对象
       // List userList = query.list(); //查询对象集合
        return user;
    }

    public void saveUser(User user) {
        getSession().save(user);
    }
}
