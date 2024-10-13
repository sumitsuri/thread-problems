package com.solution.lld.scheduler.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public abstract class MessageAttributes {
    private String id;
    private Long publishedAt;

    public MessageAttributes(){
        this.id = UUID.randomUUID().toString();
        this.publishedAt = System.currentTimeMillis();
    }
}
