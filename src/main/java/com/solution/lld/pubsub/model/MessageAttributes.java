package com.solution.lld.pubsub.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageAttributes {

    private String messageId;
    private String traceId;
    private Long publishTime;

    public MessageAttributes(String messageId, Long publishTime){
        this.messageId = messageId;
        this.publishTime = publishTime;
    }
}
