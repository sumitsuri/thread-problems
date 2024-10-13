package com.solution.lld.ratelimit;

public interface RateLimiter {
    boolean allowRequest(String clientId);
}
