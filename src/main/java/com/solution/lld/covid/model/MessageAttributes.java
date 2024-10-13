package com.solution.lld.covid.model;

import lombok.Getter;

import java.util.UUID;

@Getter
public class MessageAttributes {

    private String messageId;
    private long publishedAt;

    public MessageAttributes(){
        this.messageId = UUID.randomUUID().toString();
        this.publishedAt = System.currentTimeMillis();
    }
}
