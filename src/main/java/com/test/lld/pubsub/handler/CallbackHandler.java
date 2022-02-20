package com.test.lld.pubsub.handler;

import com.test.lld.pubsub.model.Message;
import com.test.lld.pubsub.model.Subscription;

import java.util.List;

public interface CallbackHandler {
    void handle(List<Message> messages, Subscription subscription);
}
