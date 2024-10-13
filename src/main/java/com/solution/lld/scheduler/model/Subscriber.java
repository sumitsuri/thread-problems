package com.solution.lld.scheduler.model;


import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
public abstract class Subscriber {

    private Subscription subscription;
    private List<Message> failedMessages;
    private AtomicInteger offsetRead;

    public Subscriber(Subscription subscription){
        this.subscription = subscription;
        this.failedMessages = Lists.newArrayList();
        this.offsetRead = new AtomicInteger(0);
    }

    public void processMessage(List<Message> messages){
        if(CollectionUtils.isEmpty(messages) || (offsetRead.get()-1 == messages.size()-1)){
            return;
        }
        int batchSize = subscription.getBatchSize();
        List<List<Message>> batchs = Lists.partition(messages.subList(this.offsetRead.get(), messages.size()),batchSize);
        for(List<Message> batch: batchs){
            subscription.getHandler().handle(batch);
            offsetRead.compareAndSet(offsetRead.get(), offsetRead.get()+batchSize);
        }
    }
}
