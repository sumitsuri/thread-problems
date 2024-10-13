package com.solution.lld.scheduler.service;

import com.solution.lld.scheduler.model.Message;
import com.solution.lld.scheduler.model.Topic;

public interface PubSubService {

    public void publish(String topic, Message message);

    public Topic getTopic(String name);
}
