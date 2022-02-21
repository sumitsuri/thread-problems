package com.test.lld.covid.service.impl;

import com.test.lld.covid.dao.TopicDao;
import com.test.lld.covid.dao.UserDao;
import com.test.lld.covid.model.Topic;
import com.test.lld.covid.model.User;
import com.test.lld.covid.service.TopicService;
import com.test.lld.covid.service.UserService;

import java.util.List;

public class TopicServiceImpl implements TopicService {

    private TopicDao topicDao;

    public TopicServiceImpl(){
        this.topicDao = new TopicDao();
    }

    @Override
    public void create(Topic topic) {
        this.topicDao.create(topic);
    }

    @Override
    public Topic get(String name) {
        return this.topicDao.get(name);
    }

    @Override
    public List<Topic> getAll() {
        return this.topicDao.getAll();
    }

    @Override
    public void update(String name, Topic topic) {
    this.topicDao.update(topic);
    }
}
