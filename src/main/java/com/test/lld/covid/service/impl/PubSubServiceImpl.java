package com.test.lld.covid.service.impl;

import com.test.lld.covid.model.Message;
import com.test.lld.covid.model.Topic;
import com.test.lld.covid.service.PubSubService;
import com.test.lld.covid.service.TopicService;

public class PubSubServiceImpl implements PubSubService {

    private TopicService topicService;
    public PubSubServiceImpl(TopicService topicService){
        this.topicService = topicService;
    }
    @Override
    public void publish(String topicName, Message message) {
        Topic topic = topicService.get(topicName);
        synchronized (topicName){
            topic.getMessages().add(message);
        }
    }
}
