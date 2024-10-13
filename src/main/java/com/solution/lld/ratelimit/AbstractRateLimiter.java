package com.solution.lld.ratelimit;

public abstract class AbstractRateLimiter implements RateLimiter {
    protected int maxRequests;
    protected long windowSizeInMilliseconds;

    public AbstractRateLimiter(int maxRequests, long windowSizeInMilliseconds) {
        this.maxRequests = maxRequests;
        this.windowSizeInMilliseconds = windowSizeInMilliseconds;
    }

    @Override
    public boolean allowRequest(String clientId) {
        return isRequestAllowed(clientId);
    }

    public abstract boolean isRequestAllowed(String clientId);
}
