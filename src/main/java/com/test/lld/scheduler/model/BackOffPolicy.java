package com.test.lld.scheduler.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BackOffPolicy {

    private int retry;
    private BackOffPolicy backOffPolicy;
}
