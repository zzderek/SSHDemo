package com.derek.dao;

import com.derek.model.User;

import java.util.List;

public interface IUserDao {

    public User findUserById(int id);

    public void saveUser(User user);
}
