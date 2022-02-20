package com.test.lld.scheduler.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RetryPolicy {

    private int MAX_RETRY = 3;

    private BackOffPolicy backOffPolicy;
    public RetryPolicy(BackOffPolicy backOffPolicy){
        this.backOffPolicy = backOffPolicy;
    }
}
