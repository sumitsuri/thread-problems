package com.test.lld.scheduler.service;

import com.google.common.collect.Maps;
import com.test.lld.scheduler.model.Message;
import com.test.lld.scheduler.model.Topic;

import java.util.Map;

public class PubSubServiceImpl implements PubSubService{

    private Map<String, Topic> topicMap;

    public PubSubServiceImpl(){
        this.topicMap = Maps.newConcurrentMap();
    }

    @Override
    public void publish(String topicName, Message message) {
    Topic topic1 = getTopic(topicName);
    topic1.getMessages().add(message);
    }

    @Override
    public Topic getTopic(String name) {
        return topicMap.get(name);
    }

}
