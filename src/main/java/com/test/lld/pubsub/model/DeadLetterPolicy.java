package com.test.lld.pubsub.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeadLetterPolicy {
    private String topicName;
}
