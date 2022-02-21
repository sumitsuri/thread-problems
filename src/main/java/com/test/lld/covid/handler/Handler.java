package com.test.lld.covid.handler;

import com.test.lld.covid.model.Message;

public interface Handler {

    public void handle(Message message);
}
