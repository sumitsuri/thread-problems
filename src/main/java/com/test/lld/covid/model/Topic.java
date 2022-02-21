package com.test.lld.covid.model;

import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@Getter
@Setter
public class Topic {

    private String id;
    private String name;
    private BlockingQueue<Message> messages;

    public Topic(String name){
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.messages = new LinkedBlockingQueue<>();
    }
}
