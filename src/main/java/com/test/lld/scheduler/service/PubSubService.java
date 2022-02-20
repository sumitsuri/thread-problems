package com.test.lld.scheduler.service;

import com.test.lld.scheduler.model.Message;
import com.test.lld.scheduler.model.Topic;

public interface PubSubService {

    public void publish(String topic, Message message);

    public Topic getTopic(String name);
}
