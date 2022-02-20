package com.test.lld.pubsub.model;

import lombok.Getter;
import lombok.Setter;
import org.json.simple.JSONObject;

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
