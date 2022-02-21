package com.test.lld.covid.service;

import com.test.lld.covid.dao.TopicDao;
import com.test.lld.covid.model.Topic;

import java.util.List;

public interface TopicService {

    public void create(Topic topic);

    public Topic get(String name);

    public List<Topic> getAll();

    public void update(String name, Topic topic);


}
