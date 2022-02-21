package com.test.lld.covid.model;

import com.test.lld.covid.handler.Handler;
import com.test.lld.covid.service.TopicService;
import lombok.SneakyThrows;


public class Subscriber implements Runnable{

    private String topicName;
    private Handler handler;
    private TopicService topicService;

    public Subscriber(String topicName, Handler handler, TopicService topicService){
        this.topicName = topicName;
        this.handler = handler;
        this.topicService = topicService;
    }

    @SneakyThrows
    @Override
    public void run() {
        Topic topic = topicService.get(topicName);
        while(true){
            Message message = topic.getMessages().take();
            handler.handle(message);
        }
    }
}
