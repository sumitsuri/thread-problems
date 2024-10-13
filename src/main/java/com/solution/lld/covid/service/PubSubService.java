package com.solution.lld.covid.service;

import com.solution.lld.covid.model.Message;

public interface PubSubService {

    public void publish(String topicName, Message message);
}
