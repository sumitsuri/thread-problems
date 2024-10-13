package com.solution.lld.scheduler.model;

import com.solution.lld.scheduler.handler.Handler;
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
