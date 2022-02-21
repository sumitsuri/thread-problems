package com.test.lld.covid.dao;

import com.google.common.collect.Maps;
import com.test.lld.covid.model.Hospital;
import com.test.lld.covid.model.User;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserDao {

    private Map<String, User> users;

    public UserDao(){
        this.users = Maps.newConcurrentMap();
    }

    public void create(User user){
        this.users.put(user.getId(), user);
    }

    public User get(String id){
        return this.users.get(id);
    }

    public List<User> getAll(){
        return Collections.unmodifiableList(users.values().stream().collect(Collectors.toList()));
    }

    public void update(User user){
        synchronized (user.getId()){
            this.users.put(user.getId(), user);
        }
    }
}
