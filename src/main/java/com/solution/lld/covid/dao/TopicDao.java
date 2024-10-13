package com.solution.lld.covid.dao;

import com.google.common.collect.Maps;
import com.solution.lld.covid.model.Topic;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TopicDao {

    private Map<String, Topic> topics;

    //see if below ds is more suitable as booking will always be associated with user
    //private Map<String, Map<String,Booking>> bookings;

    public TopicDao(){
        this.topics = Maps.newConcurrentMap();
    }

    public String create(Topic topic){
        this.topics.put(topic.getName(), topic);
        return topic.getId();
    }

    public Topic get(String name){
        return this.topics.get(name);
    }

    public List<Topic> getAll(){
        return Collections.unmodifiableList(topics.values().stream().collect(Collectors.toList()));
    }

    public void update(Topic topic){
        this.topics.put(topic.getName(), topic);
    }

}
