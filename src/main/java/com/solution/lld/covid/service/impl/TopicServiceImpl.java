package com.solution.lld.covid.service.impl;

import com.solution.lld.covid.dao.TopicDao;
import com.solution.lld.covid.model.Topic;
import com.solution.lld.covid.service.TopicService;

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
