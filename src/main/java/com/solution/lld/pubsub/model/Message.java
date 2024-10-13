package com.solution.lld.pubsub.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Message extends MessageAttributes{

    private String payload;

    public Message(String payload){
        super(UUID.randomUUID().toString(), System.currentTimeMillis());
        this.payload = payload;
    }
}
