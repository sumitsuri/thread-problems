package com.solution.lld.pubsub.service.impl;

import com.google.common.collect.Maps;
import com.solution.lld.pubsub.model.Message;
import com.solution.lld.pubsub.model.Subscriber;
import com.solution.lld.pubsub.model.Subscription;
import com.solution.lld.pubsub.model.Topic;
import com.solution.lld.pubsub.service.IPubSubService;

import java.util.Map;

public class PubSubServiceImpl implements IPubSubService {

    private Map<String, Topic> topics;
    private Map<String, Subscription> subscriptions;
    private Map<String, Map<String, Subscriber>> topicSubscribers;

    public PubSubServiceImpl(){
        this.topics = Maps.newConcurrentMap();;
        this.subscriptions = Maps.newConcurrentMap();
        this.topicSubscribers = Maps.newConcurrentMap();
    }
    @Override
    public void createTopic(Topic topic) {
        synchronized (topic){
            if(this.topics.containsKey(topic.getName())){
                throw new RuntimeException(String.format("Topic with name [%s] already exists", topic.getName()));
            }
            this.topics.put(topic.getName(), topic);
        }
    }


    @Override
    public Topic getTopic(String name) {
        if(!this.topics.containsKey(name)){
            throw new RuntimeException(String.format("Topic with name [%s] is not present", name));
        }
        return this.topics.get(name);
    }

    @Override
    public void createSubscription(Subscription subscription) {

    }

    @Override
    public Subscription getSubscription(String name) {
        return null;
    }

    //See if some listener can be added for message size change and then consumer can run on it's own.
    @Override
    public void publishMessage(String topic, Message message) {
        Topic topic1 = getTopic(topic);
        synchronized (this){
            topic1.getMessages().add(message);
        }
    }
}
