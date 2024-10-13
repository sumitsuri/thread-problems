package com.solution.lld.covid.service.impl;

import com.solution.lld.covid.model.Message;
import com.solution.lld.covid.model.Topic;
import com.solution.lld.covid.service.PubSubService;
import com.solution.lld.covid.service.TopicService;

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
