package com.test.lld.covid.service.impl;

import com.test.lld.covid.dao.UserDao;
import com.test.lld.covid.model.User;
import com.test.lld.covid.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl(){
        this.userDao = new UserDao();
    }

    @Override
    public void create(User user) {
        this.userDao.create(user);
    }

    @Override
    public User get(String id) {
        return this.userDao.get(id);
    }

    @Override
    public List<User> getAll() {
        return this.userDao.getAll();
    }

    @Override
    public void update(String id, User user) {
    this.userDao.update(user);
    }
}
