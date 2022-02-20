package com.test.lld.pubsub.controller;

import com.test.lld.pubsub.handler.HttpCallbackHandler;
import com.test.lld.pubsub.handler.SimpleCallbackHandler;
import com.test.lld.pubsub.model.*;
import com.test.lld.pubsub.service.IPubSubService;
import com.test.lld.pubsub.service.impl.PubSubServiceImpl;

public class AppRunner {

    public static void main(String[] args){
        System.out.println("App starting...");
        System.out.println("======================");

        IPubSubService pubSubService = new PubSubServiceImpl();

        pubSubService.createTopic(Topic.of("topic-1"));
        pubSubService.createTopic(Topic.of("topic-2"));

        Subscription s1 = Subscription.builder()
                .name("s1")
                .topic("topic-1")
                .endpoint("www.google.com")
                .retryPolicy(new RetryPolicy(1, new BackOffPolicy(1, BackOffType.FIXED)))
                .batchSize(3)
                .callbackHandler(new SimpleCallbackHandler())
                .build();

        Subscription s2 = Subscription.builder()
                .name("s2")
                .topic("topic-2")
                .endpoint("https://webhook.site/16c5a039-156b-400f-8f3e-6519a5ed3c6e")
                .retryPolicy(new RetryPolicy(2, new BackOffPolicy(1, BackOffType.EXPONENTIAL)))
                .batchSize(2)
                .callbackHandler(new HttpCallbackHandler())
                .build();

        pubSubService.createSubscription(s1);
        pubSubService.createSubscription(s2);

        pubSubService.publishMessage("topic-1", new Message("m1"));
        pubSubService.publishMessage("topic-2", new Message("m2"));

    }
}
