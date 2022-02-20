package com.test.lld.scheduler.model;

import com.test.lld.scheduler.handler.Handler;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Subscription {

    private String name;
    private String topicName;
    private RetryPolicy retryPolicy;
    private int batchSize;
    private Handler handler;
}
