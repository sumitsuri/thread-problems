package com.test.lld.covid.service;

import com.test.lld.covid.model.User;

import java.util.List;

public interface UserService {

    public void create(User user);

    public User get(String id);

    public List<User> getAll();

    public void update(String id, User user);
}
