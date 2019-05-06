package com.derek.service;

import com.derek.dao.impl.UserDaoImpl;
import com.derek.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
@Service
public class UserService {
    @Autowired
    private UserDaoImpl userDao;

    public List<User> getUserById(Integer id){
        return userDao.findUserById(id);
    }

    public void saveBook(User user) {
        userDao.saveUser(user);

    }
}
