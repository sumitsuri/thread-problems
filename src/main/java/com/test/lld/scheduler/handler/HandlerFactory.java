package com.test.lld.scheduler.handler;

import com.test.lld.scheduler.types.HandlerType;

public class HandlerFactory {

    public Handler getHandler(HandlerType handlerType){
        switch (handlerType){
            case JOB_EXECUTOR:
                return new JobExecutorHandler();
            default:
                throw new RuntimeException(String.format("Handler [%s] not supported", handlerType));
        }
    }
}
