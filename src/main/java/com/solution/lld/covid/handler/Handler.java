package com.solution.lld.covid.handler;

import com.solution.lld.covid.model.Message;

public interface Handler {

    public void handle(Message message);
}
