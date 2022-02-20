package com.test.lld.pubsub.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RetryPolicy {

    public static final Integer DEFAULT_MAX_ATTEMPTS = 1;
    public static final Integer MAX_MAX_ATTEMPTS = 5;

    public static final Integer DEFAULT_BACKOFF_SECONDS = 1;
    public static final Integer MAX_BACKOFF_SECONDS = 5;

    private Integer maxAttempt;
    private BackOffPolicy backOffPolicy;
}
