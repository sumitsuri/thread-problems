package com.test.lld.pubsub.model;

import com.google.common.collect.Lists;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

//Implement partition for topic and subscriber should listen from partition.
//publish message to topic partition.
//consumer subscribing to partition of topic.
public class Subscriber implements Runnable{

    private Subscription subscription;
    private AtomicInteger offsetRead;
    private List<Message> deadLetterMessages;

    public static Subscriber of(Subscription subscription){
        return new Subscriber(subscription);
    }

    public Subscriber(Subscription subscription){
        this.subscription = subscription;
        this.offsetRead = new AtomicInteger(0);
        this.deadLetterMessages = Lists.newLinkedList();

    }

    public void processMessages(List<Message> messages){
        if(CollectionUtils.isEmpty(messages) || (messages.size()-1 == offsetRead.get()-1)){
            return;
        }

        int batchSize = subscription.getBatchSize();
        List<List<Message>> batches = Lists.partition(messages.subList(offsetRead.get(), messages.size()), batchSize);
        for(List<Message> batch : batches){
            subscription.getCallbackHandler().handle(batch, subscription);
            offsetRead.compareAndSet(offsetRead.get(), offsetRead.get() + batchSize);
        }
    }

    @Override
    public void run() {

    }
}
