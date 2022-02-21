package com.test.lld.covid.service;

import com.test.lld.covid.model.Message;

public interface PubSubService {

    public void publish(String topicName, Message message);
}
