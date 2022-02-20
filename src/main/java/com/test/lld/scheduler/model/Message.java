package com.test.lld.scheduler.model;

import com.google.gson.JsonObject;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Message extends MessageAttributes{

    private JsonObject message;

    public static Message of(JsonObject message){
        return new Message(message);
    }

    public Message(JsonObject message){
            super();
            this.message = message;
    }
}
