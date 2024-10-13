package com.solution.lld.ratelimit;

public class RateLimiterFactory {

    public static RateLimiter createRateLimiter(RatelimitType type, int maxRequests, long windowSizeInMilliseconds) throws IllegalAccessException {
        switch (type){
            case FIXED:
                return new FixedWindowRateLimiter(maxRequests, windowSizeInMilliseconds);
            case SLIDING:
                return new SlidingWindowRateLimiter(maxRequests, windowSizeInMilliseconds);
            default:
                throw new IllegalAccessException("Unsupported rate limiter type");
        }
    }
}
