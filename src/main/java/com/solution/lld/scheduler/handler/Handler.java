package com.solution.lld.scheduler.handler;

import com.solution.lld.scheduler.model.Message;

import java.util.List;

public interface Handler {

    public void handle(List<Message> messages);
}
