package com.test.lld.scheduler.handler;

import com.test.lld.scheduler.model.Message;

import java.util.List;

public interface Handler {

    public void handle(List<Message> messages);
}
