package com.test.lld.scheduler.model;

import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class Topic {

    private String id;
    private String name;
    private List<Message> messages;

    public Topic(String name){
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.messages = Lists.newArrayList();
    }
}
