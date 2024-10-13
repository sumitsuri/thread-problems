package com.solution.lld.pubsub.model;

import com.google.common.base.Preconditions;
import com.solution.lld.pubsub.handler.CallbackHandler;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.StringUtils;

@Getter
@Setter
@Builder
public class Subscription {

    private String name;
    private String topic;
    private String endpoint;
    private int batchSize;
    private RetryPolicy retryPolicy;
    private CallbackHandler callbackHandler;
    private DeadLetterPolicy deadLetterPolicy;

    private static final Integer DEFAULT_BATCH_SIZE = 1;
    private static final Integer MAX_BATCH_SIZE = 5;


    public void validate(){
        Preconditions.checkArgument(!StringUtils.isEmpty(name), String.format("Invalid name: [%s]", name));
        Preconditions.checkArgument(!StringUtils.isEmpty(topic), String.format("Invalid topic name: [%s]", topic));
        Preconditions.checkArgument(StringUtils.isEmpty(endpoint), String.format("Invalid endpoint: [%s]", endpoint));
        Preconditions.checkArgument(batchSize > 0 && batchSize <= MAX_BATCH_SIZE, String.format("Batch size should be between [%s] and [%s]", 1, MAX_BATCH_SIZE));
        Preconditions.checkArgument(callbackHandler != null, String.format("handler cannot be null"));
    }


}
