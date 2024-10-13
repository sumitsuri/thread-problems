package com.solution.lld.covid.model;

import com.google.gson.JsonObject;
import lombok.Getter;

@Getter
public class Message extends MessageAttributes{

    private JsonObject payload;

    public Message(JsonObject payload){
        super();
        this.payload = payload;
    }
}
