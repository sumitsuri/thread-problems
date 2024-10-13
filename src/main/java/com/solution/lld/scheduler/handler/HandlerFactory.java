package com.solution.lld.scheduler.handler;

import com.solution.lld.scheduler.types.HandlerType;

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
