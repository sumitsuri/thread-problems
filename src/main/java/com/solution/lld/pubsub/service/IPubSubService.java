package com.solution.lld.pubsub.service;

import com.solution.lld.pubsub.model.Message;
import com.solution.lld.pubsub.model.Subscription;
import com.solution.lld.pubsub.model.Topic;

public interface IPubSubService {

    public void createTopic(Topic topic);
    public Topic getTopic(String name);
    public void createSubscription(Subscription subscription);
    public Subscription getSubscription(String name);
    public void publishMessage(String topic, Message message);
}
