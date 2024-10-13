package com.solution.lld.pubsub.handler;

import com.solution.lld.pubsub.model.Message;
import com.solution.lld.pubsub.model.Subscription;

import java.util.List;

public interface CallbackHandler {
    void handle(List<Message> messages, Subscription subscription);
}
