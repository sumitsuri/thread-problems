package com.test.lld.pubsub.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BackOffPolicy {

    private Integer backOffSeconds;
    private BackOffType backOffType;

    public Integer getNextBackOffInterval(int currentBackoff, int retryCount){
        switch (backOffType){
            case FIXED:
                return backOffSeconds;
            case EXPONENTIAL:
                return (int)(currentBackoff + (backOffSeconds * Math.pow(2, retryCount-1)));
            default:
                throw new RuntimeException("Not supported type");
        }
    }
}
